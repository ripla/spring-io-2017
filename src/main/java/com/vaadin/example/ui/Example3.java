package com.vaadin.example.ui;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Push;
import com.vaadin.example.insurance.AgeRange;
import com.vaadin.example.insurance.City;
import com.vaadin.example.insurance.InsuranceService;
import com.vaadin.example.insurance.PriceResult;
import com.vaadin.example.ui.reactive.ReactiveComboBox;
import com.vaadin.example.ui.reactive.ReactiveLabel;
import com.vaadin.example.ui.reactive.ReactiveNotification;
import com.vaadin.example.ui.reactive.ReactiveRadioButtonGroup;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import reactor.core.publisher.Flux;

@SpringUI(path = "/example3")
@Push
public class Example3 extends UI {

    @Autowired
    private InsuranceService insuranceService;

    private ReactiveRadioButtonGroup<AgeRange> ageSelector;
    private ReactiveComboBox<City> citySelector;
    private ReactiveLabel priceLabel;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();

        Flux<AgeRange> ageRangeStream = ageSelector.getValueStream();

        Flux<City> cityStream = citySelector.getValueStream();

        Flux<PriceResult> priceStream = Flux.combineLatest(ageRangeStream,
                cityStream,
                (ageRange, city) -> insuranceService.calculatePrice(ageRange,
                        city))
                .share();

        priceLabel.setValueStream(priceStream.filter(PriceResult::isSuccess)
                .map(r -> Double.toString(r.getPrice()) + " €"));

        priceLabel.setVisible(priceStream.map(PriceResult::isSuccess));

        ReactiveNotification.setErrorNotificationStream(getUI(),
                priceStream.filter(PriceResult::isFailure)
                        .map(PriceResult::getError));
    }

    private void setupLayout() {
        VerticalLayout container = new VerticalLayout();
        container.setSizeFull();

        Panel panel = new Panel("Insurance price calculator");
        panel.setHeight("200px");
        panel.setWidth("-1");

        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setHeight("100%");

        ageSelector = new ReactiveRadioButtonGroup<>("Age range",
                Arrays.asList(AgeRange.values()));
        ageSelector.setItemCaptionGenerator(AgeRange::getCaption);

        citySelector = new ReactiveComboBox<>("City",
                Arrays.asList(City.values()));
        citySelector.setEmptySelectionAllowed(false);

        priceLabel = new ReactiveLabel();
        priceLabel.setCaption("Insurance price");
        priceLabel.setStyleName(ValoTheme.LABEL_HUGE);
        priceLabel.setVisible(false);

        layout.addComponents(ageSelector, citySelector, priceLabel);
        layout.setComponentAlignment(citySelector, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(priceLabel, Alignment.MIDDLE_CENTER);
        panel.setContent(layout);

        container.addComponent(panel);
        container.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        setContent(container);
    }
}

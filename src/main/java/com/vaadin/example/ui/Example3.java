package com.vaadin.example.ui;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Push;
import com.vaadin.example.insurance.AgeRange;
import com.vaadin.example.insurance.City;
import com.vaadin.example.insurance.InsuranceService;
import com.vaadin.example.ui.reactive.ReactiveComboBox;
import com.vaadin.example.ui.reactive.ReactiveLabel;
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
    InsuranceService insuranceService;

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout container = new VerticalLayout();
        container.setSizeFull();

        Panel panel = new Panel("Insurance price calculator");
        panel.setHeight("200px");

        HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setSizeFull();

        ReactiveRadioButtonGroup<AgeRange> ageSelector = new ReactiveRadioButtonGroup<>(
                "Age" + " range", Arrays.asList(AgeRange.values()));
        ageSelector.setItemCaptionGenerator(AgeRange::getCaption);

        ReactiveComboBox<City> citySelector = new ReactiveComboBox<>("City",
                Arrays.asList(City.values()));

        ReactiveLabel priceLabel = new ReactiveLabel();
        priceLabel.setCaption("");
        priceLabel.setStyleName(ValoTheme.LABEL_HUGE);

        layout.addComponents(ageSelector, citySelector, priceLabel);
        layout.setComponentAlignment(citySelector, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(priceLabel, Alignment.MIDDLE_CENTER);
        panel.setContent(layout);

        container.addComponent(panel);
        container.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
        setContent(container);

        Flux<AgeRange> ageRangeStream = ageSelector.getValueStream();

        Flux<City> cityStream = citySelector.getValueStream();

        Flux<String> priceStream = Flux.combineLatest(ageRangeStream,
                cityStream,
                (ageRange, city) -> insuranceService.calculatePrice(ageRange,
                        city))
                .map(price -> {
                    if (price.isSuccess()) {
                        return Double.toString(price.getPrice()) + " €";
                    } else {
                        return price.getError();
                    }
                });

        priceLabel.setValueStream(priceStream);
    }
}

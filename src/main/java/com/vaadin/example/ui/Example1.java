package com.vaadin.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Push;
import com.vaadin.example.ui.weather.WeatherQueryView;
import com.vaadin.example.weather.WeatherService;
import com.vaadin.example.weather.dto.WeatherResult;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI(path = "/example1")
@Push
public class Example1 extends UI {

    @Autowired
    private WeatherService weatherService;

    private WeatherQueryView mainView;

    @Override
    protected void init(VaadinRequest request) {
        mainView = new WeatherQueryView();
        setContent(mainView);

        mainView.getQueryWeatherButton()
                .addClickListener(e -> startLoading());
    }

    private void showResult(WeatherResult result) {
        access(() -> {
            mainView.getLoadingIndicator()
                    .setVisible(false);
            mainView.getWeatherDisplay()
                    .showData(result);
            mainView.getWeatherDisplay()
                    .setVisible(true);
        });
    }

    private void startLoading() {
        mainView.getLoadingIndicator()
                .setVisible(true);
        mainView.getQueryWeatherButton()
                .setVisible(false);

        //lat and long for Avinguda Diagonal 547
        weatherService.
                getCurrentHourlyWeather(41.390355, 2.136259)
                .subscribe(this::showResult);
    }
}

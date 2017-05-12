package com.vaadin.example.ui.weather;

import com.vaadin.ui.Button;
import com.vaadin.ui.ProgressBar;

public class WeatherQueryView extends WeatherQueryDesign {


    public Button getQueryWeatherButton() {
        return queryWeather;
    }

    public ProgressBar getLoadingIndicator() {
        return loadingIndicator;
    }

    public WeatherDisplay getWeatherDisplay() {
        return weatherDisplay;
    }
}

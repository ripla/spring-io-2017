package com.vaadin.example.ui.weather;

import java.util.Date;

import com.vaadin.example.weather.dto.WeatherData;
import com.vaadin.example.weather.dto.WeatherResult;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.DateRenderer;

public class WeatherDisplay extends WeatherDisplayDesign{

    public WeatherDisplay() {
        Grid.Column<WeatherData, Date> time = (Grid.Column<WeatherData, Date>) grid
                .getColumn("time");
        time.setRenderer(new DateRenderer("%1$tH:%1$tM"));
    }

    public void showData(WeatherResult result) {
        this.temperature.setValue(result.getCurrently().getTemperature() + "˚");
        this.shortSummary.setValue(result.getCurrently().getSummary());
        this.longSummary.setValue(result.getHourly().getSummary());

        grid.setItems(result.getHourly().getData());
    }
}

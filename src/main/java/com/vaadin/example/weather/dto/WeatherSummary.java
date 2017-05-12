package com.vaadin.example.weather.dto;

import java.util.List;

public class WeatherSummary {

    private String summary;
    private String icon;
    private List<WeatherData> data = null;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherSummary{" + "summary='" + summary + '\'' + ", icon='" +
                icon + '\'' + ", data=" + data + '}';
    }
}
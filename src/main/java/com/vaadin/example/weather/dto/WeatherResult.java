package com.vaadin.example.weather.dto;

public class WeatherResult {

    private double latitude;
    private double longitude;
    private String timezone;
    private long offset;
    private CurrentWeather currently;
    private WeatherSummary hourly;
    private WeatherSummary minutely;

    public WeatherResult() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public CurrentWeather getCurrently() {
        return currently;
    }

    public void setCurrently(CurrentWeather currently) {
        this.currently = currently;
    }

    public WeatherSummary getHourly() {
        return hourly;
    }

    public void setHourly(WeatherSummary hourly) {
        this.hourly = hourly;
    }

    public WeatherSummary getMinutely() {
        return minutely;
    }

    public void setMinutely(WeatherSummary minutely) {
        this.minutely = minutely;
    }

    @Override
    public String toString() {
        return "WeatherResult{" + "latitude=" + latitude + ", longitude=" +
                longitude + ", timezone='" + timezone + '\'' + ", offset=" +
                offset + ", currently=" + currently + ", hourly=" + hourly +
                '}';
    }
}

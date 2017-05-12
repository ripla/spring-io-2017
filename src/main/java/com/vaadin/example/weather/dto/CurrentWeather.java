package com.vaadin.example.weather.dto;

public class CurrentWeather {

    private long time;
    private String summary;
    private String icon;
    private long nearestStormDistance;
    private long nearestStormBearing;
    private long precipIntensity;
    private long precipProbability;
    private double temperature;
    private double apparentTemperature;
    private double dewPoint;
    private double humidity;
    private double windSpeed;
    private long windBearing;
    private double visibility;
    private double cloudCover;
    private double pressure;
    private double ozone;

    public CurrentWeather() {
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

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

    public long getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(long nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public long getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(long nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public long getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(long precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public long getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(long precipProbability) {
        this.precipProbability = precipProbability;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(long windBearing) {
        this.windBearing = windBearing;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" + "time=" + time + ", summary='" + summary +
                '\'' + ", icon='" + icon + '\'' + ", nearestStormDistance=" +
                nearestStormDistance + ", nearestStormBearing=" +
                nearestStormBearing + ", precipIntensity=" + precipIntensity +
                ", precipProbability=" + precipProbability + ", temperature=" +
                temperature + ", apparentTemperature=" + apparentTemperature +
                ", dewPoint=" + dewPoint + ", humidity=" + humidity +
                ", windSpeed=" + windSpeed + ", windBearing=" + windBearing +
                ", visibility=" + visibility + ", cloudCover=" + cloudCover +
                ", pressure=" + pressure + ", ozone=" + ozone + '}';
    }
}
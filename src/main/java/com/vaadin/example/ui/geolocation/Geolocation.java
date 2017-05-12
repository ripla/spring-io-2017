package com.vaadin.example.ui.geolocation;

public class Geolocation {
    private final double latitude;
    private final double longitude;

    public Geolocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Geolocation{" + "latitude=" + latitude + ", longitude=" +
                longitude + '}';
    }
}

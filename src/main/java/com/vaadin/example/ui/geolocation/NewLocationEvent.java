package com.vaadin.example.ui.geolocation;

import com.vaadin.event.ConnectorEvent;

public class NewLocationEvent extends ConnectorEvent {

    private final Geolocation geolocation;

    public NewLocationEvent(GeolocationExtension source, Geolocation geolocation) {
        super(source);
        this.geolocation = geolocation;
    }

    public double getLatitude() {
        return geolocation.getLatitude();
    }

    public double getLongitude() {
        return geolocation.getLongitude();
    }

    public Geolocation getLocation() {
        return geolocation;
    }
}

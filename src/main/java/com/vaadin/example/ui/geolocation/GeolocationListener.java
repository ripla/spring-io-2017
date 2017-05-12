package com.vaadin.example.ui.geolocation;

import java.lang.reflect.Method;

import com.vaadin.util.ReflectTools;

@FunctionalInterface
public interface GeolocationListener {

    Method NEW_LOCATION_METHOD = ReflectTools
            .findMethod(GeolocationListener.class, "newLocation",
                    NewLocationEvent.class);

    void newLocation(NewLocationEvent location);
}

package com.vaadin.example.ui.geolocation;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractJavaScriptExtension;
import com.vaadin.shared.Registration;

@JavaScript("GeolocationExtensionConnector.js")
public class GeolocationExtension extends AbstractJavaScriptExtension {

    public GeolocationExtension(AbstractClientConnector clientConnector) {
        super(clientConnector);

        addFunction("geolocationSuccess", arguments -> {
            final Geolocation newLocation = new Geolocation(arguments.get(0)
                    .asNumber(), arguments.get(1)
                    .asNumber());

            fireEvent(new NewLocationEvent(this, newLocation));
        });

        //TODO proper error handling
        addFunction("geoLocationFail", System.err::println);
    }

    public void askLocation() {
        this.callFunction("askLocation");
    }

    public Registration addGeolocationListener(GeolocationListener listener) {
        return addListener(NewLocationEvent.class, listener,
                GeolocationListener.NEW_LOCATION_METHOD);
    }
}

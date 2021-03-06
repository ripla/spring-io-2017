package com.vaadin.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Push;
import com.vaadin.example.ui.geolocation.Geolocation;
import com.vaadin.example.ui.geolocation.GeolocationExtension;
import com.vaadin.example.ui.geolocation.GeolocationListener;
import com.vaadin.example.ui.weather.WeatherQueryView;
import com.vaadin.example.weather.WeatherService;
import com.vaadin.example.weather.dto.WeatherResult;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringUI(path = "/example2")
@Push
public class Example2 extends UI {

    @Autowired
    private WeatherService weatherService;

    private WeatherQueryView mainView;

    private Disposable streamSubscription;

    @Override
    protected void init(VaadinRequest request) {
        mainView = new WeatherQueryView();
        setContent(mainView);

        Mono<Geolocation> currentLocation = createGeolocationMono(
                new GeolocationExtension(this));

        Flux<Button.ClickEvent> clickStream = createWeatherClickStream(
                mainView.getQueryWeatherButton());

        streamSubscription = clickStream
                .doOnNext(e -> startLoading())
                .flatMap(click -> currentLocation)
                .flatMap(gl -> weatherService.getCurrentHourlyWeather(
                        gl.getLatitude(), gl.getLongitude()))
                .subscribe(this::showResult);

        addDetachListener(e -> streamSubscription.dispose());
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
        access(() -> {
            mainView.getLoadingIndicator()
                    .setVisible(true);
            mainView.getWeatherDisplay()
                    .setVisible(false);
        });
    }

    private Flux<Button.ClickEvent> createWeatherClickStream(Button button) {
        return Flux.push(fluxSink -> {
            Registration listenerRegistration = button.addClickListener(
                    fluxSink::next);

            fluxSink.onDispose(listenerRegistration::remove);
        });
    }

    private Mono<Geolocation> createGeolocationMono(
            GeolocationExtension geolocationExtension) {
        return Mono.create(geolocationMonoSink -> {
            GeolocationListener locationListener = e -> geolocationMonoSink
                    .success(
                    e.getLocation());

            Registration listenerRegistration = geolocationExtension.addGeolocationListener(
                    locationListener);

            geolocationExtension.askLocation();

            geolocationMonoSink
                    .onDispose(listenerRegistration::remove);
        });
    }
}

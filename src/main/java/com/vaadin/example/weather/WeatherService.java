package com.vaadin.example.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.vaadin.example.weather.dto.WeatherResult;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient weatherClient = WebClient.create(
            "https://api.darksky.net/forecast");

    @Value("${apiKey}")
    private String apiKey;

    public Mono<WeatherResult> getCurrentHourlyWeather(double latitude,
            double longitude) {
        return weatherClient
                .get()
                .uri(builder -> builder
                        .path("/{apiKey}/{latitude},{longitude}")
                        .queryParam("units", "si")
                        .queryParam("exclude",
                                "minutely,daily,alerts,flags")
                        .build(apiKey, latitude, longitude))
                .retrieve()
                .bodyToMono(WeatherResult.class);
    }
}

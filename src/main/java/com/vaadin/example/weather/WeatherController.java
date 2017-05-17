package com.vaadin.example.weather;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaadin.example.weather.dto.WeatherData;
import com.vaadin.example.weather.dto.WeatherResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(value = "/weather/hourly/feed/{latitude},{longitude}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    Flux<WeatherData> fetchHourlyWeatherFeed(@PathVariable double latitude,
            @PathVariable double longitude) {

        return Flux.zip(
                Flux.interval(Duration.ofSeconds(0), Duration.ofSeconds(1)),
                weatherService.getCurrentHourlyWeather(latitude, longitude)
                        .map(weatherResult -> weatherResult.getHourly()
                                .getData())
                        .flatMapMany(Flux::fromIterable))
                .map(Tuple2::getT2)
                .share();
    }

    @GetMapping(value = "/weather/current/{latitude},{longitude}")
    @ResponseBody
    Mono<WeatherResult> fetchCurrentWeather(@PathVariable double latitude,
            @PathVariable double longitude) {
        return weatherService.getCurrentHourlyWeather(latitude, longitude);
    }
}

package com.teco.weatherapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "openWeather", url = "${openweather.url}")
public interface OpenWeatherRestClient {

    @GetMapping("/weather")
    String currentByCity(@RequestParam String q, @RequestParam String appid);

    @GetMapping("/forecast")
    String forecastByCity(@RequestParam String q, @RequestParam String appid);
}

package com.teco.weatherapi.controllers;

import com.teco.weatherapi.services.IGeoLocationService;
import com.teco.weatherapi.services.IWeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class WeatherController {

    private IWeatherService weatherService;
    private IGeoLocationService geoLocationService;

    public WeatherController(IWeatherService weatherService, IGeoLocationService geoLocationService) {
        this.weatherService = weatherService;
        this.geoLocationService = geoLocationService;
    }

    @GetMapping("/location")
    public String location(){
        return geoLocationService.getLocation();
    }

    @GetMapping("/current")
    public String currentWeather(){
        return weatherService.current();
    }

    @GetMapping("/current/{city}")
    public String currentWeatherByCity(@PathVariable String city){
        return weatherService.currentByCity(city);
    }

    @GetMapping("/forecast")
    public String forecastWeather(){
        return weatherService.forecast();
    }

    @GetMapping("/forecast/{city}")
    public String forecastWeatherByCity(@PathVariable String city){
        return weatherService.forecastByCity(city);
    }
}

package com.teco.weatherapi.services;

import com.teco.weatherapi.clients.OpenWeatherRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService implements IWeatherService{

    @Value("${openweather.appid}")
    private String appid;

    private OpenWeatherRestClient openWeatherRestClient;
    private GeoLocationService geoLocationService;

    public WeatherService(OpenWeatherRestClient openWeatherRestClient, GeoLocationService geoLocationService) {
        this.openWeatherRestClient = openWeatherRestClient;
        this.geoLocationService = geoLocationService;
    }

    @Override
    public String currentByCity(String city){
        return openWeatherRestClient.currentByCity(city, appid);
    }

    @Override
    public String forecastByCity(String city){
        return openWeatherRestClient.forecastByCity(city, appid);
    }

    @Override
    public String current() {
        String city = geoLocationService.getCity();
        return openWeatherRestClient.currentByCity(city, appid);
    }

    @Override
    public String forecast() {
        String city = geoLocationService.getCity();
        return openWeatherRestClient.forecastByCity(city, appid);
    }
}

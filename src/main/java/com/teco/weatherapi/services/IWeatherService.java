package com.teco.weatherapi.services;

public interface IWeatherService {
    String currentByCity(String city);

    String forecastByCity(String city);

    String current();

    String forecast();
}

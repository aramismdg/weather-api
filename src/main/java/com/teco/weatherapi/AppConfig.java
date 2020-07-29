package com.teco.weatherapi;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate clientRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public JsonParser jsonParser() {
        return JsonParserFactory.getJsonParser();
    }
}

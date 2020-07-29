package com.teco.weatherapi.services;

import com.teco.weatherapi.clients.IpApiClient;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GeoLocationService implements IGeoLocationService {

    private IpApiClient ipApiClient;
    private JsonParser jsonParser;

    public GeoLocationService(IpApiClient ipApiClient, JsonParser jsonParser) {
        this.ipApiClient = ipApiClient;
        this.jsonParser = jsonParser;
    }

    @Override
    public String getLocation() {
        return ipApiClient.getLocation();
    }

    @Override
    public String getCity(){
        String response = ipApiClient.getLocation();
        Map<String, Object> map = jsonParser.parseMap(response);
        return map.get("city").toString();
    }

}

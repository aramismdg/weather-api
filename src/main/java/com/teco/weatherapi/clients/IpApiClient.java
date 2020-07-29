package com.teco.weatherapi.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ip-api", url = "${ip-api.url}")
public interface IpApiClient {

    @GetMapping("/")
    public String getLocation();
}

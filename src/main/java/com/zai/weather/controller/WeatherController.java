package com.zai.weather.controller;

import com.zai.weather.dto.WeatherResponse;
import com.zai.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam(value = "city") String city) {
        log.info("Weather API invoked, calling weather service.");
        WeatherResponse response = service.getWeather(city);
        return ResponseEntity.ok(response);
    }
}

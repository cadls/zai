package com.zai.weather.service;

import com.zai.weather.constants.WeatherConstant;
import com.zai.weather.dto.OpenWeatherResponse;
import com.zai.weather.dto.WeatherResponse;
import com.zai.weather.dto.WeatherStackResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Slf4j
@Service
public class WeatherService {

    @Value("${weather.stack.api.key}")
    private String weatherStackApiKey;

    @Value("${open.weather.api.key}")
    private String openWeatherApiKey;

    public WeatherResponse getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();

        String weatherStackUrl = UriComponentsBuilder.fromUriString(WeatherConstant.WEATHER_STACK_URL)
                .queryParam(WeatherConstant.ACCESS_KEY_PARAM, weatherStackApiKey)
                .queryParam(WeatherConstant.QUERY_PARAM, city)
                .toUriString();

        ResponseEntity<WeatherStackResponse> responseEntity = restTemplate.exchange(weatherStackUrl, HttpMethod.GET, null, WeatherStackResponse.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK && !Objects.isNull(responseEntity.getBody())) {
            WeatherStackResponse wsResponse = responseEntity.getBody();
            return new WeatherResponse(wsResponse.getCurrent().getWindSpeed(), wsResponse.getCurrent().getTemperature());
        } else {
            // failover
            log.info("WeatherStack API returned {} status code, Calling OpenWeather API", responseEntity.getStatusCode().value());
            String openWeatherUrl = UriComponentsBuilder.fromUriString(WeatherConstant.OPEN_WEATHER_URL)
                    .queryParam(WeatherConstant.Q_PARAM, city)
                    .queryParam(WeatherConstant.APP_ID, openWeatherApiKey)
                    .queryParam(WeatherConstant.UNITS, "metric") // Celsius
                    .toUriString();

            OpenWeatherResponse owResponse = restTemplate.exchange(openWeatherUrl, HttpMethod.GET, null, OpenWeatherResponse.class).getBody();

            return new WeatherResponse(owResponse.getWind().getSpeed(), owResponse.getMain().getTemp());
        }
    }

}

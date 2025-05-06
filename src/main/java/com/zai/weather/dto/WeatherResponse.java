package com.zai.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponse {

    @JsonProperty("wind_speed")
    private int windSpeed;

    @JsonProperty("temperature_degrees")
    private int temperatureDegrees;
}

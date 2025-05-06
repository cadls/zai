package com.zai.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherStackResponse {

    private Current current;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Current {

        @JsonProperty("wind_speed")
        private int windSpeed;

        private int temperature;
    }

}

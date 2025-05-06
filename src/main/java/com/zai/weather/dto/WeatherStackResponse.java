package com.zai.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherStackResponse {

    private Current current;

    @Data
    public static class Current {

        @JsonProperty("wind_speed")
        private int windSpeed;

        private int temperature;
    }

}

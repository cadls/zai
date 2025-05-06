package com.zai.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpenWeatherResponse {

    private Main main;

    private Wind wind;

    @Data
    public static class Main {
        private int temp;
    }

    @Data
    public static class Wind {
        private int speed;
    }
}

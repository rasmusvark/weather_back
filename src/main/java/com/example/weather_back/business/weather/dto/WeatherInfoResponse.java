package com.example.weather_back.business.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
public class WeatherInfoResponse {
    @JsonProperty("name")
    private String cityName;

    private Main main;
    private Wind wind;
    private Instant dt;

    @Data
    @NoArgsConstructor
    public static class Main {
        @JsonProperty("temp")
        private BigDecimal temperature;
        private BigDecimal humidity;
    }

    @Data
    @NoArgsConstructor
    public static class Wind {
        @JsonProperty("speed")
        private BigDecimal windSpeed;
    }
}






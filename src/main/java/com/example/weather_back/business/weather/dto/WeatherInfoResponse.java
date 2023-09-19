package com.example.weather_back.business.weather.dto;

import com.example.weather_back.domain.weatherinfo.WeatherInfo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link WeatherInfo}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfoResponse implements Serializable {
    private String cityName;
    @NotNull
    private BigDecimal temperature;
    @NotNull
    private BigDecimal windSpeed;
    @NotNull
    private BigDecimal humidity;
    @NotNull
    private Instant time;
}
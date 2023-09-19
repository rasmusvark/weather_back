package com.example.weather_back.business.city.dto;

import com.example.weather_back.domain.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Value
public class CityDto implements Serializable {
    Integer cityId;
    @NotNull
    @Size(max = 255)
    String cityName;
}
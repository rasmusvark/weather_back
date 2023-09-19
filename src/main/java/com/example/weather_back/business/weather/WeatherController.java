package com.example.weather_back.business.weather;

import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Resource
    private WeatherService weatherService;

    @GetMapping("/city/weather")
    @Operation(summary = "Toob andmebaasist valitud linna ilmainfo.")
    public List<WeatherInfoResponse> getCityWeatherInfo (@RequestParam Integer cityId) {
        return weatherService.getCityWeatherInfo(cityId);

    }
}

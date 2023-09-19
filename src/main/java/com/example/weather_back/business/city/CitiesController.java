package com.example.weather_back.business.city;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @PostMapping("/city")
    @Operation(summary = "Uue linna lisamine.")
    public void addCity(@RequestParam String cityName) {
        citiesService.addCity(cityName);
    }
}

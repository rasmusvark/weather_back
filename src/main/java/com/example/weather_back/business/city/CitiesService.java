package com.example.weather_back.business.city;

import com.example.weather_back.domain.city.City;
import com.example.weather_back.domain.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CitiesService {
    @Resource
    private CityService cityService;

    public void addCity(String cityName) {
        cityService.validateCityNameIsAvailable(cityName);
        createAndSaveCity(cityName);
    }

    private void createAndSaveCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        cityService.saveCity(city);
    }
}

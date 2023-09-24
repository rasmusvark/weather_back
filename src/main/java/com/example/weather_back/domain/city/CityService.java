package com.example.weather_back.domain.city;

import com.example.weather_back.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public void validateCityNameIsAvailable(String cityName) {
        boolean cityExists = cityRepository.cityExistsBy(cityName);
        ValidationService.validateCityNameIsAvailable(cityExists);
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);

    }
}


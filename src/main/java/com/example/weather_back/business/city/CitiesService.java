package com.example.weather_back.business.city;

import com.example.weather_back.business.city.dto.CityDto;
import com.example.weather_back.domain.city.City;
import com.example.weather_back.domain.city.CityMapper;
import com.example.weather_back.domain.city.CityService;
import com.example.weather_back.domain.weatherinfo.WeatherInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {
    @Resource
    private CityService cityService;
    @Resource
    private CityMapper cityMapper;
    @Resource
    private WeatherInfoService weatherInfoService;

    public void addCity(String cityName) {
        cityService.validateCityNameIsAvailable(cityName);
        createAndSaveCity(cityName);
    }

    public List<CityDto> getCities() {
        List<City> cities = cityService.getCities();
        return cityMapper.toDtos(cities);
    }

    private void createAndSaveCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        cityService.saveCity(city);
    }
}

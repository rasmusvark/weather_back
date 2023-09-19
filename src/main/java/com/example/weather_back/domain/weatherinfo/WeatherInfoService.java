package com.example.weather_back.domain.weatherinfo;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherInfoService {
    @Resource
    private WeatherInfoRepository weatherInfoRepository;

    public List<WeatherInfo> getWeatherInfoBy(Integer cityId) {
        return weatherInfoRepository.getWeatherInfoBy((cityId));
    }
}

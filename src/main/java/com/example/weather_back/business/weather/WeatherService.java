package com.example.weather_back.business.weather;

import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import com.example.weather_back.domain.weatherinfo.WeatherInfo;
import com.example.weather_back.domain.weatherinfo.WeatherInfoMapper;
import com.example.weather_back.domain.weatherinfo.WeatherInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;

@Service
public class WeatherService {
    @Resource
    private WeatherInfoService weatherInfoService;
    @Resource
    private WeatherInfoMapper weatherInfoMapper;


    public List<WeatherInfoResponse> getCityWeatherInfo(Integer cityId) {
        List<WeatherInfo> weatherInfos = weatherInfoService.getWeatherInfoBy(cityId);
        return weatherInfoMapper.toWeatherInfoResponses(weatherInfos);

    }
}

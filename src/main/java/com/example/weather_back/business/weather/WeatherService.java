package com.example.weather_back.business.weather;

import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import com.example.weather_back.domain.weatherinfo.WeatherInfo;
import com.example.weather_back.domain.weatherinfo.WeatherInfoMapper;
import com.example.weather_back.domain.weatherinfo.WeatherInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    @Resource
    private WeatherInfoService weatherInfoService;
    @Resource
    private WeatherInfoMapper weatherInfoMapper;

        private final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}";

        public WeatherInfoResponse fetchWeatherData(String cityName) {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(API_URL, WeatherInfoResponse.class, cityName, "bfab3e7021cf671ceabf6f7584227fef");
        }

    public List<WeatherInfoResponse> getCityWeatherInfo(Integer cityId) {
        List<WeatherInfo> weatherInfos = weatherInfoService.getWeatherInfoBy(cityId);
        return weatherInfoMapper.toWeatherInfoResponses(weatherInfos);


    }
}

package com.example.weather_back.business.weather;

import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import com.example.weather_back.domain.weatherinfo.WeatherInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
        private final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}";

        public WeatherInfoResponse fetchWeatherData(String cityName) {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(API_URL, WeatherInfoResponse.class, cityName, "bfab3e7021cf671ceabf6f7584227fef");
        }
    }

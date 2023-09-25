package com.example.weather_back.domain.city;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class CityValidationService {

    private final String OPEN_WEATHER_API_URL = "http://api.openweathermap.org/data/2.5/weather";

    @Value("${openweathermap.api.key}")
    private String apiKey;


    public boolean isCityNameIncorrect(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s", OPEN_WEATHER_API_URL, cityName, apiKey);

        try {
            restTemplate.getForObject(url, String.class);
            return false;
        } catch (HttpClientErrorException.NotFound e) {
            return true;
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error validating city name", e);
        } catch (Exception e) {
            throw new RuntimeException("Error validating city name", e);
        }
    }
}
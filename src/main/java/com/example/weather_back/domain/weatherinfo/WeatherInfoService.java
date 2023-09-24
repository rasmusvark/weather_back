package com.example.weather_back.domain.weatherinfo;
import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import com.example.weather_back.domain.city.City;
import com.example.weather_back.util.TimeConverter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class WeatherInfoService {
    @Resource
    private WeatherInfoRepository weatherInfoRepository;

    private final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={apiKey}&units=metric";

    @Value("${openweathermap.api.key}")
    private String apiKey;


    public void fetchAndSaveWeatherDataByCityName(City city) {

        RestTemplate restTemplate = new RestTemplate();
        WeatherInfoResponse response = restTemplate.getForObject(API_URL, WeatherInfoResponse.class, city.getName(), apiKey);
        WeatherInfo weatherInfo = createAndSetWeatherInfo(city, response);
        weatherInfoRepository.save(weatherInfo);
    }

    public List<WeatherInfo> getWeatherInfoBy(Integer cityId) {
        return weatherInfoRepository.getWeatherInfoBy((cityId));
    }

    private static WeatherInfo createAndSetWeatherInfo(City city, WeatherInfoResponse response) {
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setCity(city);
        weatherInfo.setTemperature(response.getMain().getTemperature());
        weatherInfo.setHumidity(response.getMain().getHumidity());
        weatherInfo.setWindSpeed(response.getWind().getWindSpeed());
        weatherInfo.setTime(TimeConverter.getEstonianTimeZoneInstant());
        return weatherInfo;
    }
}


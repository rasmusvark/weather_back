package com.example.weather_back.domain.weatherinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Integer> {
    @Query("select w from WeatherInfo w where w.city.id = ?1 order by w.time")
    List<WeatherInfo> getWeatherInfoBy(Integer id);
}
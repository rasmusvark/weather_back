package com.example.weather_back.domain.weatherinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Integer> {
    @Query("select w from WeatherInfo w where w.city.id = ?1 order by w.time")
    List<WeatherInfo> getWeatherInfoBy(Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM WeatherInfo w WHERE w.city.id = :cityId")
    void deleteByCityId(@Param("cityId") Integer cityId);

}
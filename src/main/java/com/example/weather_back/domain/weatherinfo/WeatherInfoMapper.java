package com.example.weather_back.domain.weatherinfo;

import com.example.weather_back.business.weather.dto.WeatherInfoResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WeatherInfoMapper {

    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "temperature", target = "main.temperature")
    @Mapping(source = "humidity", target = "main.humidity")
    @Mapping(source = "windSpeed", target = "wind.windSpeed")
    @Mapping(source = "time", target = "dt")
    WeatherInfoResponse toWeatherInfoResponse(WeatherInfo weatherInfo);

    List<WeatherInfoResponse> toWeatherInfoResponses(List<WeatherInfo> weatherInfos);
}
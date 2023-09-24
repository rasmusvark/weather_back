package com.example.weather_back.domain.city;

import com.example.weather_back.business.city.dto.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    @Mapping(source = "name", target = "cityName")
    @Mapping(source = "id", target = "cityId")
    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);
}
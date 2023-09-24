package com.example.weather_back.business.city;

import com.example.weather_back.business.city.dto.CityDto;
import com.example.weather_back.domain.weatherinfo.WeatherInfoRepository;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;
    @Resource
    private WeatherInfoRepository weatherInfoRepository;


    @PostMapping("/city")
    @Operation(summary = "Uue linna lisamine.")
    public void addCity(@RequestParam String cityName) {
        citiesService.addCity(cityName);
    }

    @GetMapping("/city")
    @Operation(
            summary = "Toob andmebaasist (city tabelist) kõikide linnade listi.",
            description = "Tagastab info koos cityId ja cityName'ga")
    public List<CityDto> getCities() {
        return citiesService.getCities();
    }

    @DeleteMapping("/city")
    @Operation(summary = "Kustutab andmebaasist valitud linna info")
    public void deleteCityInfo(@RequestParam Integer cityId) {
        citiesService.deleteCityInfo(cityId);



    }
}

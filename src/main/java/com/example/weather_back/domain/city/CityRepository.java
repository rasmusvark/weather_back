package com.example.weather_back.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select (count(c) > 0) from City c where upper(c.name) = upper(?1)")
    boolean cityExistsBy(String name);
}
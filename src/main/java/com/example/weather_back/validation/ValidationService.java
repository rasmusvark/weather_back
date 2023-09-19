package com.example.weather_back.validation;

import com.example.weather_back.infrastructure.exception.BusinessException;
import static com.example.weather_back.validation.Error.*;
public class ValidationService {

    public static void validateCityNameIsAvailable(boolean cityExists) {
        if (cityExists) {
            throw new BusinessException(CITY_ALREADY_EXISTS.getMessage(), CITY_ALREADY_EXISTS.getErrorCode());
        }
    }
}

package com.example.weather_back.validation;

import com.example.weather_back.infrastructure.exception.BusinessException;
import com.example.weather_back.infrastructure.exception.DataNotFoundException;

import static com.example.weather_back.validation.Error.*;
public class ValidationService {

    public static void validateCityNameIsAvailable(boolean cityExists) {
        if (cityExists) {
            throw new BusinessException(CITY_ALREADY_EXISTS.getMessage(), CITY_ALREADY_EXISTS.getErrorCode());
        }
    }


    public static void validateIsCityNameIncorrect(boolean cityNameIsIncorrect) {
        if (cityNameIsIncorrect) {
            throw new DataNotFoundException(CITY_NAME_IS_INCORRECT.getMessage(), CITY_NAME_IS_INCORRECT.getErrorCode());
        }
    }
}

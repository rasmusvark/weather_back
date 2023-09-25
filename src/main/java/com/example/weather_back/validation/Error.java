package com.example.weather_back.validation;

import lombok.Getter;

@Getter
public enum Error {

    CITY_ALREADY_EXISTS ("City is already added",222),
    CITY_NAME_IS_INCORRECT("City name is incorrect",333);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
    }

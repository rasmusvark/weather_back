package com.example.weather_back.validation;

import lombok.Getter;

@Getter
public enum Error {

    CITY_ALREADY_EXISTS ("Selline linn on juba lisatud.",222);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
    }

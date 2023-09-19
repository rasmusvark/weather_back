package com.example.weather_back.infrastructure.exception;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public DataNotFoundException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}

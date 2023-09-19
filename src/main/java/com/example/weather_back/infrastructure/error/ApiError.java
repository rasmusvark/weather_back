package com.example.weather_back.infrastructure.error;

import lombok.Data;
@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}
package com.example.weather_back.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeConverter {
    public static Instant getEstonianTimeZoneInstant() {
        return LocalDateTime.now().plusHours(3).atZone(ZoneId.of("Europe/Tallinn")).toInstant();
    }
}

package com.example.weather_back.domain.weatherinfo;

import com.example.weather_back.domain.city.City;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

@Service
public class WeatherSchedulerService {

    @Resource
    private WeatherInfoService weatherInfoService;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
    private final ConcurrentHashMap<Integer, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();


    public void scheduleWeatherTaskForCity(City city) {
        Runnable task = () -> weatherInfoService.fetchAndSaveWeatherDataByCityName(city);

        ScheduledFuture<?> existingTask = scheduledTasks.get(city.getId());
        if (existingTask != null) {
            existingTask.cancel(false);
        }
        ScheduledFuture<?> scheduledTask = scheduler.scheduleAtFixedRate(task, 15, 15, TimeUnit.MINUTES);
        scheduledTasks.put(city.getId(), scheduledTask);
    }

    public void cancelWeatherTaskForCity(int cityId) {
        ScheduledFuture<?> scheduledTask = scheduledTasks.get(cityId);
        if (scheduledTask != null) {
            scheduledTask.cancel(false);
        }
    }
}
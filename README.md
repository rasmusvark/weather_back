I used public weather API (https://openweathermap.org/api) and built a backend API on top of it in java/spring-boot that would perform the following functionalities:

1. It is possible to save the city name in the database, at which point the weather data will be requested every 15 minutes, the temperature, wind speed, humidity and time of day are saved in the database.
2. An API interface through which you can get these cities with the weather information that is stored in the database.
3. API interface through which cities can be deleted from the list so that no more information is polled.

   ## Related Repositories
- [Frontend Repository](https://github.com/rasmusvark/weather_front)
- [Backend Repository](https://github.com/rasmusvark/weather_back)

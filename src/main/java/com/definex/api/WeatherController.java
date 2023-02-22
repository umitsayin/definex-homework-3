package com.definex.api;

import com.definex.api.response.DataResponse;
import com.definex.model.WeatherList;
import com.definex.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/daily")
    public ResponseEntity<DataResponse<WeatherList>> getDailyWeatherByCityNameAndCountryCode(@RequestParam String cityName,
                                                                                         @RequestParam String countryCode){
        return ResponseEntity.ok(weatherService.getDailyWeatherByCityNameAndCountryCode(cityName,countryCode));
    }

    @GetMapping("/weekly")
    public ResponseEntity<DataResponse<WeatherList>> getWeeklyWeatherByCityNameAndCountryCode(@RequestParam String cityName,
                                                                               @RequestParam String countryCode){
        return ResponseEntity.ok(weatherService.getWeeklyWeatherByCityNameAndCountryCode(cityName,countryCode));
    }

    @GetMapping("/monthly")
    public ResponseEntity<DataResponse<WeatherList>> getMonthlyWeatherByCityNameAndCountryCode(@RequestParam String cityName,
                                                                               @RequestParam String countryCode){
        return ResponseEntity.ok(weatherService.getMonthlyWeatherByCityNameAndCountryCode(cityName,countryCode));
    }
}

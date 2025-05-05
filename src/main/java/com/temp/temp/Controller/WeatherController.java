package com.temp.temp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.temp.temp.DTO.WeatherResponse;
import com.temp.temp.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public WeatherResponse getByCity(@RequestParam String city) {
        return weatherService.getWeatherByCity(city);
    }
}


package com.temp.temp.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.temp.temp.DTO.WeatherResponse;




@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherResponse getWeatherByCity(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather"
                   + "?q={city}&appid={apiKey}&units=metric";

        RestTemplate rest = new RestTemplate();
        // fill placeholders
        Map<String, Object> apiResp = rest.getForObject(
            url, Map.class,
            Map.of("city", city, "apiKey", apiKey)
        );

        // parse JSON
        @SuppressWarnings("unchecked")
        Map<String,Object> main = (Map<String,Object>) apiResp.get("main");

        WeatherResponse wr = new WeatherResponse();
        wr.setCity((String) apiResp.get("name"));
        wr.setTemperature(((Number)main.get("temp")).doubleValue());
        return wr;
    }
}


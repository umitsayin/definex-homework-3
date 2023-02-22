package com.definex.service.impl;

import com.definex.api.response.DataResponse;
import com.definex.api.response.SuccessDataResponse;
import com.definex.model.WeatherList;
import com.definex.service.WeatherService;
import com.definex.util.WeatherSelectType;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;
    private final Environment env;

    @Override
    public DataResponse<WeatherList> getDailyWeatherByCityNameAndCountryCode(String cityName, String countryCode) {
        return new SuccessDataResponse<WeatherList>("SUCCESS_FETCH",
                restTemplate.getForObject(getUrl(cityName,countryCode,WeatherSelectType.DAILY.getValue()),
                        WeatherList.class));
    }

    @Override
    public DataResponse<WeatherList> getWeeklyWeatherByCityNameAndCountryCode(String cityName, String countryCode) {
        return new SuccessDataResponse<WeatherList>("SUCCESS_FETCH",
                restTemplate.getForObject(getUrl(cityName,countryCode,WeatherSelectType.WEEKLY.getValue()),
                        WeatherList.class));
    }

    @Override
    public DataResponse<WeatherList> getMonthlyWeatherByCityNameAndCountryCode(String cityName, String countryCode) {
        return new SuccessDataResponse<WeatherList>("SUCCESS_FETCH",
                restTemplate.getForObject(getUrl(cityName,countryCode,WeatherSelectType.MONTHLY.getValue()),
                        WeatherList.class));
    }

    private String getUrl(String cityName, String countryCode, String forecastType){
        return env.getProperty("weather.api.url")
                + cityName
                + "," + countryCode
                + "/" + forecastType
                + "?include=days&unitGroup=metric&key="
                + env.getProperty("weather.api.key");
    }
}

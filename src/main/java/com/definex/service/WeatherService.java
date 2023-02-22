package com.definex.service;

import com.definex.api.response.DataResponse;
import com.definex.model.WeatherList;

public interface WeatherService {
    DataResponse<WeatherList> getDailyWeatherByCityNameAndCountryCode(String cityName, String countryCode);
    DataResponse<WeatherList> getWeeklyWeatherByCityNameAndCountryCode(String cityName, String countryCode);
    DataResponse<WeatherList> getMonthlyWeatherByCityNameAndCountryCode(String cityName, String countryCode);

}

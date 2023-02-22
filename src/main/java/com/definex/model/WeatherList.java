package com.definex.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherList {
    private String address;
    private String timezone;
    private List<Weather> days;
}

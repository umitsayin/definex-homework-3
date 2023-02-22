package com.definex.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private String datetime;
    private double tempmax;
    private double tempmin;
    private double temp;
}

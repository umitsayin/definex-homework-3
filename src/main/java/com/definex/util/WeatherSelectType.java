package com.definex.util;

public enum WeatherSelectType {
    DAILY("today"),
    WEEKLY("next7days"),
    MONTHLY("next30days");

    private String value;
    WeatherSelectType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

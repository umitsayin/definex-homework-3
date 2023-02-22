package com.definex.api.response;

import lombok.Data;

@Data
public class DataResponse <T>{
    private String message;
    private boolean status;
    private T data;

    public DataResponse(String message, boolean status, T data){
        this.message = message;
        this.status = status;
        this.data = data;
    }
}

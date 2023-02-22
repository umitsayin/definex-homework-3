package com.definex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RestClientException.class})
    public ResponseEntity<Map<String,String>> entityNotFoundException(RestClientException exception,
                                                                      HttpServletRequest request){
        final Map<String, String> errors = new HashMap<>();

        errors.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
        errors.put("message", exception.getMessage());
        errors.put("path", request.getServletPath());
        errors.put("date", String.valueOf(ZonedDateTime.now()));

        return ResponseEntity.ok().body(errors);
    }
}

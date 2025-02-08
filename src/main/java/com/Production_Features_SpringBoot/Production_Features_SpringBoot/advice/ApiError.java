package com.Production_Features_SpringBoot.Production_Features_SpringBoot.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus statusCode;

    public ApiError(String error, HttpStatus statusCode) {
        this();
        this.error = error;
        this.statusCode = statusCode;
    }

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }
}

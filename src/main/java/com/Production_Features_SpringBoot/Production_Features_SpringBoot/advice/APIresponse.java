package com.Production_Features_SpringBoot.Production_Features_SpringBoot.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class APIresponse<T>{
    private T data;
    private ApiError error;
 //   @JsonFormat(pattern ="hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;

    public APIresponse(T data) {
        this();
        this.data = data;
    }

    public APIresponse() {

        this.timeStamp = LocalDateTime.now();
    }

    public APIresponse(ApiError error) {
        this();
        this.error = error;
    }
}

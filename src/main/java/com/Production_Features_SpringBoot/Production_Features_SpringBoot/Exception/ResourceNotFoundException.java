package com.Production_Features_SpringBoot.Production_Features_SpringBoot.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

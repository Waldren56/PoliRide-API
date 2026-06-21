package com.example.demo.vehicles.expeption;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String type) {
        super("Could not find vehicle " + type);
    }
}
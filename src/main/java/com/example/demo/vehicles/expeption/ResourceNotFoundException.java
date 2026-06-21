package com.example.demo.vehicles.expeption;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Could not find vehicle " + id);
    }
}
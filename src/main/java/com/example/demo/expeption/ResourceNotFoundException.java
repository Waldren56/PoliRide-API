package com.example.demo.expeption;

import com.example.demo.vehicles.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception handler
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Message) {
        super("Message: " + Message);
    }
}
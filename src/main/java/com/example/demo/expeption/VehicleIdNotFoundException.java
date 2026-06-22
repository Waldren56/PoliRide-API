package com.example.demo.expeption;

import com.example.demo.vehicles.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exception handler
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleIdNotFoundException extends RuntimeException {
    public VehicleIdNotFoundException(String Message, Vehicle.Type type, Long id) {
        super("Message: " + Message);
    }
}
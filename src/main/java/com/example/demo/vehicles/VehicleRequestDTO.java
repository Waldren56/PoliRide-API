package com.example.demo.vehicles;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record VehicleRequestDTO(
        @NotNull(message = "Vehicle type has to be specified")
        Vehicle.Type type,

        @Min(value = 0, message = "Please, enter a value higher or equal to 0")
        @Max(value = 100, message = "Please, enter a value lower or equal to 100")
        Integer batteryLevel,

        @NotNull(message = "Longitude is requested")
        Double longitude,

        @NotNull(message = "Latitude is requested")
        Double latitude,

        @NotNull(message = "Please enter if vehicle is available or not")
        Boolean available
) { }
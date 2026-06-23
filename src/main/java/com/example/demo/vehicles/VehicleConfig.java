package com.example.demo.vehicles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VehicleConfig {
    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository vehicleRepository) {
        return args -> {
            // Adding first vehicle ( object )
            Vehicle vehicle1 = new Vehicle(
                    Vehicle.Type.ECAR,
                    6,
                    43.7696,
                    11.2558,
                    true
            );
            // Adding second vehicle ( object )
            Vehicle vehicle2 = new Vehicle(
                    Vehicle.Type.EBIKE,
                    32,
                    41.7056012,
                    13.2528969,
                    true
            );
            // Adding third vehicle ( object )
            Vehicle vehicle3 = new Vehicle(
                    Vehicle.Type.EBIKE,
                    72,
                    45.453321,
                    85.245254,
                    true
            );
            vehicleRepository.saveAll(List.of(vehicle1, vehicle2, vehicle3));
        };
    }
}
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
            Vehicle vehicle1 = new Vehicle(
                    Vehicle.Type.ECAR,
                    56,
                    43.7696,
                    11.2558,
                    true
            );
            Vehicle vehicle2 = new Vehicle(
                    Vehicle.Type.EBIKE,
                    32,
                    41.7056012,
                    13.2528969,
                    false
            );
            vehicleRepository.saveAll(List.of(vehicle1, vehicle2));
        };
    }
}
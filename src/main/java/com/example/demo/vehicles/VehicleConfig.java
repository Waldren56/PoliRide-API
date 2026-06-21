package com.example.demo.vehicles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.example.demo.vehicles.Vehicle.VehicleState.In_Use;
import static com.example.demo.vehicles.Vehicle.VehicleType.Bicycle;
import static com.example.demo.vehicles.Vehicle.VehicleState.Available;
import static com.example.demo.vehicles.Vehicle.VehicleType.Car;

@Configuration
public class VehicleConfig {

    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository vehicleRepository) {
        return args -> {
            if (vehicleRepository.count() == 0) {
                Vehicle vehicle1 = new Vehicle(
                        Bicycle,
                        20,
                        Available
                );
                Vehicle vehicle2 = new Vehicle(
                        Car,
                        80,
                        In_Use
                );

                vehicleRepository.saveAll(List.of(vehicle1, vehicle2));
            }
        };
    }
}
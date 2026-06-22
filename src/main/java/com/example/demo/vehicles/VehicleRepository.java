package com.example.demo.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findVehicleByType(Vehicle.Type type);

    Optional<Vehicle> findVehicleById(Long id);
}
package com.example.demo.vehicles;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Optional<Vehicle> findVehicleById(Long id);
}
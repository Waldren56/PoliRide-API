package com.example.demo.vehicles;

import com.example.demo.vehicles.expeption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/vehicles")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Vehicle> getProductById(@PathVariable("id") Long id) {
        return Collections.singletonList(vehicleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utente non trovato con id: " + id)));
    }
}
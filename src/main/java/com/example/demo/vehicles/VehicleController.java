package com.example.demo.vehicles;

import com.example.demo.vehicles.expeption.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @GetMapping(params = "type")
    public List<Vehicle> findByType(@RequestParam("type") String type) {
        return Collections.singletonList(vehicleRepository.findVehicleByType(Vehicle.Type.valueOf(type.toUpperCase()))
                .orElseThrow(() -> new ResourceNotFoundException(type)));
    }
}
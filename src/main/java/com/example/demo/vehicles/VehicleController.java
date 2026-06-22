package com.example.demo.vehicles;

import com.example.demo.expeption.ResourceNotFoundException;
import com.example.demo.expeption.VehicleIdNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    // Initializing repository for the controller
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Standard GET request for see every object
    @GetMapping
    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    // GET request filtered by type parameter
    @GetMapping(params = "type")
    public List<Vehicle> findByType(@RequestParam("type") String type, Vehicle vehicle) {
        return Collections.singletonList(vehicleRepository.findVehicleByType(Vehicle.Type.valueOf(type.toUpperCase()))
                .orElseThrow(() -> new ResourceNotFoundException(type)));
    }

    // GET request filtered by id
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findById(id));
    }

    // Standard POST request
    @PostMapping
    public Vehicle create(@Valid @RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Standard PUT request
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleRepository.findVehicleById(id)
                .map(existingVehicle -> {
                    if (vehicle.getType() != null && !vehicle.getType().equals(existingVehicle.getType())) {
                        existingVehicle.setType(vehicle.getType());
                    }
                    existingVehicle.setBatteryLevel(vehicle.getBatteryLevel());
                    existingVehicle.setLongitude(vehicle.getLongitude());
                    existingVehicle.setLatitude(vehicle.getLatitude());
                    existingVehicle.setAvailable(vehicle.isAvailable());


                    Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
                    return ResponseEntity.ok(updatedVehicle);
                }).orElseThrow(() -> new VehicleIdNotFoundException("Vehicle with id " + id + " not found", vehicle.getType(), id));
    }
}
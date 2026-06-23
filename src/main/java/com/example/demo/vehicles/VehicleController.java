package com.example.demo.vehicles;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    // Initializing repository for the controller
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Standard GET request for see every object
    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> findAll() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    // GET request filtered by id
    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.findById(id));
    }

    // GET request filtered by type parameter
    @GetMapping(params = "type")
    public ResponseEntity<List<VehicleResponseDTO>> findByType(@RequestParam("type") String type) {
        return ResponseEntity.ok(vehicleService.findByType(type));
    }

    // Standard POST request
    @PostMapping
    public ResponseEntity<VehicleResponseDTO> create(@Valid @RequestBody VehicleRequestDTO vehicleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.create(vehicleRequest));
    }

    // Standard PUT request
    @PutMapping("/{id}")
    public VehicleResponseDTO update(@PathVariable Long id, @Valid @RequestBody VehicleRequestDTO dto) {
        return vehicleService.update(id, dto);
    }

    // Standard DELETE request through id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
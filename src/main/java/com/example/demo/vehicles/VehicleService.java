package com.example.demo.vehicles;

import com.example.demo.expeption.InvalidVehicleException;
import com.example.demo.expeption.VehicleIdNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional(readOnly = true)
    public VehicleResponseDTO findById(Long id) {
        return vehicleRepository.findById(id)
                .map(VehicleResponseDTO::fromEntity)
                .orElseThrow(() -> new VehicleIdNotFoundException("Vehicle with id " + id + " not found", null, id));
    }

    @Transactional(readOnly = true)
    public List<VehicleResponseDTO> findByType(String type) {
        try {
            Vehicle.Type vehicleType = Vehicle.Type.valueOf(type.toUpperCase());
            return vehicleRepository.findVehicleByType(vehicleType)
                    .stream()
                    .map(VehicleResponseDTO::fromEntity)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new InvalidVehicleException("Invalid vehicle type: " + type);
        }
    }

    @Transactional(readOnly = true)
    public List<VehicleResponseDTO> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public VehicleResponseDTO create(VehicleRequestDTO dto) {
        Vehicle vehicle = new Vehicle(
                dto.type(),
                dto.batteryLevel(),
                dto.longitude(),
                dto.latitude(),
                dto.available()
        );
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return VehicleResponseDTO.fromEntity(savedVehicle);
    }

    public VehicleResponseDTO update(Long id, VehicleRequestDTO dto) {
        return vehicleRepository.findById(id)
                .map(existingVehicle -> {
                    if(dto.type() != null) existingVehicle.setType(dto.type());
                    if(dto.batteryLevel() != null) existingVehicle.setBatteryLevel(dto.batteryLevel());
                    if(dto.longitude() != null) existingVehicle.setLongitude(dto.longitude());
                    if(dto.latitude() != null) existingVehicle.setLatitude(dto.latitude());
                    if(dto.available() != null) existingVehicle.setAvailable(dto.available());

                    if(dto.batteryLevel() < 15) existingVehicle.setAvailable(false);

                    Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
                    return VehicleResponseDTO.fromEntity(updatedVehicle);
                }).orElseThrow(() -> new VehicleIdNotFoundException("Vehicle with id " + id + " not found", dto.type(), id));
    }

    public void delete(Long id) {
        if(!vehicleRepository.existsById(id)) {
            throw new VehicleIdNotFoundException("Vehicle with id " + id + " not found", null, id);
        }
        vehicleRepository.deleteById(id);
    }
}
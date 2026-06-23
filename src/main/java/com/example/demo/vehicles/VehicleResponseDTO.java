package com.example.demo.vehicles;

public record VehicleResponseDTO(
        Vehicle.Type type,
        String serialNumber,
        Integer batteryLevel,
        double longitude,
        Double latitude,
        Boolean available,
        Long id
) {
    public static VehicleResponseDTO fromEntity(Vehicle vehicle) {
        return new VehicleResponseDTO(vehicle.getType(),
                vehicle.getSerialNumber(),
                vehicle.getBatteryLevel(),
                vehicle.getLongitude(),
                vehicle.getLatitude(),
                vehicle.isAvailable(),
                vehicle.getId()
        );
    }
}
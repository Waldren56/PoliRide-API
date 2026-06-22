package com.example.demo.vehicles;

public record VehicleResponseDTO(
        Vehicle.Type type,
        int batteryLevel,
        double longitude,
        double latitude,
        boolean available
) {
    public static VehicleResponseDTO fromEntity(Vehicle vehicle) {
        String displayVehicle = vehicle.getType()
                + " "
                + vehicle.getBatteryLevel()
                + " "
                + vehicle.getLongitude()
                + " "
                + vehicle.getLatitude()
                + " "
                + vehicle.isAvailable();

        return new VehicleResponseDTO(vehicle.getType(),
                vehicle.getBatteryLevel(),
                vehicle.getLongitude(),
                vehicle.getLatitude(),
                vehicle.isAvailable()
        );
    }
}
package com.example.demo.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    // Creating all the fields for the vehicle
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_number", nullable = false, unique = true, updatable = false)
    private String serialNumber = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    public enum Type {
        ECAR,
        SCOOTER,
        EBIKE
    }

    @Min(value = 0, message = "Please, enter a number above 0.")
    @Max(value = 100, message = "Please, enter a number below 100.")
    private int batteryLevel;

    private double longitude;
    private double latitude;

    @JsonProperty("available")
    private boolean available;

    // Empty constructor
    public Vehicle(){}

    // Personalized constructor
    public Vehicle(Type type, int batteryLevel, double longitude, double latitude, boolean available){
        this.type = type;
        this.serialNumber = UUID.randomUUID().toString();
        this.batteryLevel = batteryLevel;
        this.longitude = longitude;
        this.latitude = latitude;
        this.available = available;
    }

    // GETTERS and SETTERS
    public String getSerialNumber() {
        return serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

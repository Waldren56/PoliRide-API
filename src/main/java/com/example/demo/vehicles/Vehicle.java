package com.example.demo.vehicles;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialCode;

    private int batteryLevel;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @Enumerated(EnumType.STRING)
    private VehicleState state;

    public enum VehicleType {
        Bicycle, Scooter, Car
    }

    public enum VehicleState {
        Available, In_Use, Maintenance
    }

    public Vehicle() {}

    public Vehicle(VehicleType type, int batteryLevel, VehicleState state) {
        this.type = type;
        this.batteryLevel = batteryLevel;
        this.state = state;
    }

    @PrePersist
    protected void onCreate() {
        if (this.serialCode == null) {
            String randomSegment = java.util.UUID.randomUUID().toString()
                    .replaceAll("-", "")
                    .substring(0, 5)
                    .toUpperCase();
            this.serialCode = "MONO-" + LocalDate.now().getYear() + "-" + randomSegment;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getType() {
        return this.type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getSerialCode() {
        return this.serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public VehicleState getState() {
        return this.state;
    }

    public void setState(VehicleState state) {
        this.state = state;
    }
}
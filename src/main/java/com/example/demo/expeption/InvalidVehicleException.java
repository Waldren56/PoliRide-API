package com.example.demo.expeption;

public class InvalidVehicleException extends RuntimeException {
  public InvalidVehicleException(String message) {
    super(message);
  }
}

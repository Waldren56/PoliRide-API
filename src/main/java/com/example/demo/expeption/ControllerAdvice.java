package com.example.demo.expeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    // Record per rappresentare la struttura JSON della risposta di errore
    public record MyErrorResponse(int status, String message) {}

    @ExceptionHandler(InvalidVehicleException.class)
    public ResponseEntity<MyErrorResponse> handleInvalidVehicle(InvalidVehicleException ex) {
        MyErrorResponse error = new MyErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MyErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        MyErrorResponse error = new MyErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleIdNotFoundException.class)
    public ResponseEntity<MyErrorResponse> handleVehicleIdNotFound(VehicleIdNotFoundException ex) {
        MyErrorResponse error = new MyErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorResponse> handleGlobalException(Exception ex) {
        MyErrorResponse error = new MyErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Errore interno del server");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
package org.example;

public class ParkFullException extends RuntimeException {
    public ParkFullException(String message) {
        super(message);
    }
}

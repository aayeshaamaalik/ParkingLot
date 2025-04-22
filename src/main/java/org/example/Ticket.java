package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private List<Spot> spots;

    public Ticket(Vehicle vehicle, List<Spot> spots) {
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
        this.spots = spots;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Spot> getSpots() {
        return spots;
    }
}


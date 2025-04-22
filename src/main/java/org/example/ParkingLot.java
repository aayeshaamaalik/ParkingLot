package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private int availableCount;
    private float hourlyRate;

    public ParkingLot(List<Level> levels, float hourlyRate) {
        this.levels = levels;
        this.hourlyRate = hourlyRate;
        this.availableCount = calculateTotalAvailableCount();
    }

    private int calculateTotalAvailableCount() {
        return levels.stream().mapToInt(Level::getAvailableCount).sum();
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public List<Spot> findSpots(Vehicle v) {
        int required = v.getSize();
        for (Level level : levels) {
            for (Row row : level.getRows()) {
                List<Spot> rowSpots = row.getSpots();
                for (int i = 0; i <= rowSpots.size() - required; i++) {
                    boolean fits = true;
                    for (int j = 0; j < required; j++) {
                        if (!rowSpots.get(i + j).getAvailable()) {
                            fits = false;
                            break;
                        }
                    }
                    if (fits) {
                        List<Spot> allocated = new ArrayList<>();
                        for (int j = 0; j < required; j++) {
                            allocated.add(rowSpots.get(i + j));
                        }
                        return allocated;
                    }
                }
            }
        }
        return null;
    }

    public Ticket parkVehicle(Vehicle v) {
        List<Spot> spots = findSpots(v);
        if (spots == null) throw new ParkFullException("No available spots for vehicle");

        for (Spot s : spots) {
            s.takeSpot();
        }

        availableCount -= v.getSize();
        return new Ticket(v, spots);
    }

    public void clearSpot(Ticket t) {
        if (t == null || t.getSpots().isEmpty()) {
            throw new InvalidTicketException("Invalid ticket");
        }

        for (Spot s : t.getSpots()) {
            s.clearSpot();
        }

        availableCount += t.getVehicle().getSize();
    }

    public float calculateFee(Ticket t) {
        Duration duration = Duration.between(t.getStartTime(), java.time.LocalDateTime.now());
        long hours = Math.max(duration.toHours(), 1); // Minimum 1 hour
        return hours * hourlyRate;
    }
}


package org.example;

public class Spot {
    private boolean available;
    private Level level;

    public Spot(Level level) {
        this.level = level;
        this.available = true;
    }

    public boolean getAvailable() {
        return available;
    }

    public void takeSpot() {
        if (!available) throw new IllegalStateException("Spot is already taken.");
        this.available = false;
        level.updateAvailableCount(-1);
    }

    public void clearSpot() {
        if (available) throw new IllegalStateException("Spot is already empty.");
        this.available = true;
        level.updateAvailableCount(1);
    }

    public Level getLevel() {
        return level;
    }
}


package org.example;

import java.util.List;

public class Level {
    private List<Row> rows;
    private int availableCount;

    public Level(List<Row> rows) {
        this.rows = rows;
        this.availableCount = calculateAvailableCount();
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void updateAvailableCount(int diff) {
        availableCount += diff;
    }

    private int calculateAvailableCount() {
        int count = 0;
        for (Row row : rows) {
            for (Spot spot : row.getSpots()) {
                if (spot.getAvailable()) count++;
            }
        }
        return count;
    }

    public List<Row> getRows() {
        return rows;
    }
}


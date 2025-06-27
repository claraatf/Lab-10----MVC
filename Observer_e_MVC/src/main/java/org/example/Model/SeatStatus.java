package org.example.Model;


public enum SeatStatus {
    AVAILABLE("Available"),
    RESERVED("Reserved"),
    UNAVAILABLE("Unavailable");

    private final String description;

    SeatStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

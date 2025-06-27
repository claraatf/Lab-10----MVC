package org.example.Model;


public class Seat {
    private final int number;
    private SeatStatus status;

    public Seat(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Seat number cannot be zero or negative.");
        }
        this.number = number;
        this.status = SeatStatus.AVAILABLE;
    }

    // Getters and Setters
    public int getNumber() {
        return number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}

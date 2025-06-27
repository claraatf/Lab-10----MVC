package org.example.Model;

import java.util.ArrayList;
import java.util.List;
import org.example.View.SeatEvent;
import org.example.View.SeatListener;

public class Bus {
    private final List<Seat> seats = new ArrayList<>();
    private final List<SeatListener> listeners = new ArrayList<>();

    public Bus(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Invalid seat capacity.");
        for (int i = 1; i <= capacity; i++) {
            this.seats.add(new Seat(i));
        }
    }

    public void addListener(SeatListener listener) {
        if (listener == null) throw new IllegalArgumentException("Listener cannot be null.");
        this.listeners.add(listener);
    }

    public void reserve(int seatNumber) {
        Seat seat = getSeatByNumber(seatNumber);
        if (seat == null) throw new IllegalArgumentException("Seat #" + seatNumber + " does not exist.");
        if (seat.getStatus() == SeatStatus.AVAILABLE) {
            seat.setStatus(SeatStatus.RESERVED);
            System.out.println("Model: Seat " + seatNumber + " has been reserved.");
            notifyListeners(seat);
        }
    }

    public void purchase(int seatNumber) {
        Seat seat = getSeatByNumber(seatNumber);
        if (seat == null) throw new IllegalArgumentException("Seat #" + seatNumber + " does not exist.");
        if (seat.getStatus() == SeatStatus.AVAILABLE || seat.getStatus() == SeatStatus.RESERVED) {
            seat.setStatus(SeatStatus.UNAVAILABLE);
            System.out.println("Model: Seat " + seatNumber + " has been purchased.");
            notifyListeners(seat);
        }
    }

    private void notifyListeners(Seat modifiedSeat) {
        SeatEvent event = new SeatEvent(this, modifiedSeat);
        for (SeatListener listener : listeners) {
            listener.seatStateChanged(event);
        }
    }

    public Seat getSeatByNumber(int number) {
        for (Seat seat : this.seats) {
            if (seat.getNumber() == number) {
                return seat;
            }
        }
        return null;
    }

    public List<Seat> getSeats() {
        return this.seats;
    }
}

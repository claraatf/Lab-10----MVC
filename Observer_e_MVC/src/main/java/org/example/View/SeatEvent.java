package org.example.View;

import java.util.EventObject;
import org.example.Model.Seat;

public class SeatEvent extends EventObject {

    private final Seat seat;

    public SeatEvent(Object source, Seat seat) {
        super(source);
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
}

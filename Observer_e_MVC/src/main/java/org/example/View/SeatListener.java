package org.example.View;

import java.util.EventListener;

public interface SeatListener extends EventListener {
    void seatStateChanged(SeatEvent event);
}

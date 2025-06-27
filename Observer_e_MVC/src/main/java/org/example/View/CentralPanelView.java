package org.example.View;

import org.example.Model.Seat;
import org.example.Model.SeatStatus;
import org.example.Model.Bus;

public class CentralPanelView implements SeatListener {
    private final Bus model;

    public CentralPanelView(Bus model) {
        this.model = model;
    }

    @Override
    public void seatStateChanged(SeatEvent event) {
        System.out.println(">>> CENTRAL PANEL: Notification received for seat " + event.getSeat().getNumber());
        drawPanel();
    }

    public void drawPanel() {
        System.out.println("\n--- CENTRAL BUS STATION PANEL ---");
        for (Seat seat : model.getSeats()) {
            String color;

            if (seat.getStatus() == SeatStatus.RESERVED) {
                color = "Yellow";
            } else if (seat.getStatus() == SeatStatus.UNAVAILABLE) {
                color = "Red";
            } else {
                color = "Green";
            }

            System.out.printf("[Seat %02d: %s] ", seat.getNumber(), color);
            if (seat.getNumber() % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n------------------------------------");
    }
}

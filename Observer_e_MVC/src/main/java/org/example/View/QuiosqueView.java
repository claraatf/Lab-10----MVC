package org.example.View;

import org.example.Model.Seat;
import org.example.Model.Bus;

public class QuiosqueView implements SeatListener {

    private final Bus model;

    public QuiosqueView(Bus model) {
        this.model = model;
    }

    @Override
    public void seatStateChanged(SeatEvent event) {
        System.out.println(">>> QUIOSQUE: Received update about seat " + event.getSeat().getNumber() + ". Updating list.");
        displayList();
    }

    public void displayList() {
        System.out.println("\n--- SELF-SERVICE KIOSK ---");
        for (Seat seat : model.getSeats()) {
            System.out.printf("Seat %d -> Status: %s\n", seat.getNumber(), seat.getStatus().getDescription());
        }
        System.out.println("------------------------------------");
    }
}

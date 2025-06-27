package org.example.Controller;

import org.example.Model.Bus;

public class BusStationController {

    private final Bus model;

    public BusStationController(Bus model) {
        this.model = model;
    }

    public void executeReservation(int seatNumber) {
        if (seatNumber <= 0) throw new IllegalArgumentException("Seat number must be greater than zero.");
        System.out.println("\nController: Received request to RESERVE seat " + seatNumber);
        model.reserve(seatNumber);
    }

    public void executePurchase(int seatNumber) {
        System.out.println("\nController: Received request to PURCHASE seat " + seatNumber);
        model.purchase(seatNumber);
    }
}

package org.example;

import org.example.Controller.BusStationController;
import org.example.Model.Bus;
import org.example.View.CentralPanelView;
import org.example.View.QuiosqueView;

public class Main {

    public static void main(String[] args) {
        try {
            Bus bus = new Bus(12);
            CentralPanelView panel = new CentralPanelView(bus);
            QuiosqueView quiosque = new QuiosqueView(bus);

            bus.addListener(panel);
            bus.addListener(quiosque);

            BusStationController controller = new BusStationController(bus);

            System.out.println("### Simulation Start ###");

            controller.executeReservation(5);
            controller.executePurchase(8);
            panel.drawPanel();

        } catch (IllegalArgumentException err) {
            System.err.println("Error: " + err.getMessage());
        }
    }
}

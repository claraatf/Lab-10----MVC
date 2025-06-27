
import org.example.Model.Bus;
import org.example.Model.Seat;
import org.example.View.SeatEvent;
import org.example.View.CentralPanelView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CentralPanelViewTest {

    private CentralPanelView panel;
    private Bus bus;

    @BeforeEach
    void setUp() {
        bus = new Bus(4); // painel organiza 4 por linha
        panel = new CentralPanelView(bus);
    }

    @Test
    void testPanelUpdatesOnEvent() {
        Seat modifiedSeat = bus.getSeatByNumber(1);
        SeatEvent event = new SeatEvent(bus, modifiedSeat);

        // Capturar o System.out
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        panel.seatStateChanged(event);

        String result = output.toString();

        System.setOut(System.out);

        assertTrue(result.contains("CENTRAL PANEL"));
        assertTrue(result.contains("Seat 01"));
    }
}

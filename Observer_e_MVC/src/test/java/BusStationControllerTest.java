
import org.example.Controller.BusStationController;
import org.example.Model.Bus;
import org.example.Model.Seat;
import org.example.Model.SeatStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusStationControllerTest {

    private Bus bus;
    private BusStationController controller;

    @BeforeEach
    void setUp() {
        bus = new Bus(10);
        controller = new BusStationController(bus);
    }

    @Test
    void testExecuteReservationValidSeat() {
        controller.executeReservation(2);
        Seat seat = bus.getSeatByNumber(2);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());
    }

    @Test
    void testExecutePurchaseValidSeat() {
        controller.executePurchase(4);
        Seat seat = bus.getSeatByNumber(4);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }

    @Test
    void testExecuteReservationInvalidSeat() {
        assertThrows(IllegalArgumentException.class, () -> controller.executeReservation(-1));
    }

    @Test
    void testExecutePurchaseUnavailableSeat() {
        // Simula reserva e depois compra
        controller.executeReservation(5);
        controller.executePurchase(5);

        Seat seat = bus.getSeatByNumber(5);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());

        // Tenta comprar de novo (já está indisponível)
        controller.executePurchase(5);  // não deve lançar exceção, apenas não muda estado
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }
}

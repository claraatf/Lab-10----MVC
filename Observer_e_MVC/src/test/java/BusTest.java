
import org.example.Model.*;
import org.example.View.SeatEvent;
import org.example.View.SeatListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    private Bus bus;

    @BeforeEach
    void setUp() {
        bus = new Bus(10);
    }

    @Test
    void testCreateBusWithValidCapacity() {
        assertEquals(10, bus.getSeats().size());
    }

    @Test
    void testCreateBusWithInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Bus(0));
    }

    @Test
    void testReserveSeat() {
        Seat seat = bus.getSeatByNumber(1);
        assertEquals(SeatStatus.AVAILABLE, seat.getStatus());

        bus.reserve(1);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());
    }

    @Test
    void testPurchaseAvailableSeat() {
        Seat seat = bus.getSeatByNumber(2);
        assertEquals(SeatStatus.AVAILABLE, seat.getStatus());

        bus.purchase(2);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }

    @Test
    void testPurchaseReservedSeat() {
        bus.reserve(3);
        Seat seat = bus.getSeatByNumber(3);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());

        bus.purchase(3);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }

    @Test
    void testInvalidSeatReservation() {
        assertThrows(IllegalArgumentException.class, () -> bus.reserve(20));
    }

    @Test
    void testInvalidSeatPurchase() {
        assertThrows(IllegalArgumentException.class, () -> bus.purchase(-1));
    }

    @Test
    void testListenerIsNotified() {
        final boolean[] notified = {false};

        SeatListener listener = new SeatListener() {
            @Override
            public void seatStateChanged(SeatEvent event) {
                notified[0] = true;
            }
        };

        bus.addListener(listener);
        bus.reserve(1);

        assertTrue(notified[0]);
    }
}

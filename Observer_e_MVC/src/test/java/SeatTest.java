

import org.example.Model.Seat;
import org.example.Model.SeatStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void testCreateValidSeat() {
        Seat seat = new Seat(1);
        assertEquals(1, seat.getNumber());
        assertEquals(SeatStatus.AVAILABLE, seat.getStatus());
    }

    @Test
    void testCreateSeatWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Seat(0));
        assertThrows(IllegalArgumentException.class, () -> new Seat(-5));
    }

    @Test
    void testSetSeatStatus() {
        Seat seat = new Seat(3);
        seat.setStatus(SeatStatus.RESERVED);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());

        seat.setStatus(SeatStatus.UNAVAILABLE);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }

    @Test
    void testSeatSetStatusToReserved() {
        Seat seat = new Seat(7);
        seat.setStatus(SeatStatus.RESERVED);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());
    }

    @Test
    void testSeatSetStatusToUnavailable() {
        Seat seat = new Seat(8);
        seat.setStatus(SeatStatus.UNAVAILABLE);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }

    @Test
    void testStatusTransition() {
        Seat seat = new Seat(9);
        assertEquals(SeatStatus.AVAILABLE, seat.getStatus());

        seat.setStatus(SeatStatus.RESERVED);
        assertEquals(SeatStatus.RESERVED, seat.getStatus());

        seat.setStatus(SeatStatus.UNAVAILABLE);
        assertEquals(SeatStatus.UNAVAILABLE, seat.getStatus());
    }
}

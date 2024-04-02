package io.warehouse13.learning;

import java.util.Random;

public record Seat(char rowMarker, int seatNumber, boolean isReserved) {
    public Seat(char rowMarker, int seatNumber) {
        this(
                rowMarker,
                seatNumber,
                //true);
                new Random().nextBoolean());
    }
}

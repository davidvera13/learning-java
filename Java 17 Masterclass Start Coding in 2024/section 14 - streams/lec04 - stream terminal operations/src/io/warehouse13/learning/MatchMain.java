package io.warehouse13.learning;

import java.util.Arrays;

public class MatchMain {
    public static void main(String[] args) {
        Seat[] seats = new Seat[100];
        Arrays.setAll(seats, i -> new Seat((char) ('A' + i / 10), i % 10 + 1));
        //Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays.stream(seats)
                .filter(Seat::isReserved)
                .count();

        System.out.println("reservationCount: " + reservationCount);

        boolean hasBookings = Arrays.stream(seats)
                .anyMatch(Seat::isReserved);
        System.out.println("hasBookings: " + hasBookings);


        boolean fullyBooked = Arrays.stream(seats)
                .allMatch(Seat::isReserved);
        System.out.println("fullyBooked: " + fullyBooked);


        boolean eventWashedOut = Arrays.stream(seats)
                .noneMatch(Seat::isReserved);
        System.out.println("eventWashedOut: " + eventWashedOut);
    }
}

package io.warehouse13.learning.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if (theatre.reserveSeat("D12")) {
            System.out.println("Pay for seat D12");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Pay for seat B13");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("D12")) {
            System.out.println("Pay for seat D12");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.0d));
        priceSeats.add(theatre.new Seat("A00", 13.0d));
        // Collections.sort(priceSeats, Theatre.PRICE_COMPARATOR);
        priceSeats.sort(Theatre.PRICE_COMPARATOR);

        printList(priceSeats);
    }
    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat: list)
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());

        System.out.println("");
        System.out.println("********************************************");
    }
}

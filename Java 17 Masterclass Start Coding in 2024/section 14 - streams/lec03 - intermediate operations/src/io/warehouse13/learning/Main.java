package io.warehouse13.learning;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // filter
        System.out.println("Using filter");
        IntStream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                .filter(i -> Character.toUpperCase(i) > 'E')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\nUsing filter and skip");
        // skip
        IntStream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                .skip(5)
                .forEach(d -> System.out.printf("%c ", d));


        System.out.println("\nUsing drop while");
        // dropwhile ..
        IntStream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                // until predicate false
                .dropWhile(i -> i <= 'E')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\ndrop while & take while");
        // dropwhile ..
        IntStream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                // until predicate false: recomanded for ordered values
                .dropWhile(i -> i <= 'E')
                .takeWhile(i -> i < 'a')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\nUsing filter & distinct");
        // distinct
        IntStream
                .iterate((int) 'A', i -> i <= (int) 'z', i -> i +1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\nUsing random");
        System.out.println("**************************************");
        Random random = new Random();
        Stream.generate(() -> random.nextInt((int) 'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));

        //System.out.println("\nUsing map & sorted");
        int maxSeats = 100;
        int seatsInRow = 10;
        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatsInRow),
                                i % seatsInRow + 1))
                        .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString));

        //System.out.println("\nUsing map & sorted");
        var stream2 =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatsInRow),
                                i % seatsInRow + 1))
                        .mapToDouble(Seat::price)
                        //.mapToObj("%.2f":: formatted)
                        .boxed()
                        .map("%.2f":: formatted);

        //stream.forEach(System.out::println);
        //stream2.forEach(System.out::println);

        System.out.println("\nUsing sorted");
        System.out.println("\nUsing peek (mainly debugging purpose)");

        Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                .map(i -> new Seat((char) ('A' + i / seatsInRow),
                        i % seatsInRow + 1))
                .skip(5)
                .peek(s -> System.out.println("---> " + s))
                .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::toString))
                .forEach(System.out::println);



    }
}

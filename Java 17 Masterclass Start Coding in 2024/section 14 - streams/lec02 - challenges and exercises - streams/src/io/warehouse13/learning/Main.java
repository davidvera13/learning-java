package io.warehouse13.learning;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    // Generate the bingo ball labels as 5 different streams, using different Stream creation methods for each.
    //Assign each pipeline to a stream variable.
    //Concatenate the five streams together.
    //Apply the terminal operation, forEach, to the final concatenated stream, to print each label.
    //These should be printed in order as follows.
    //B1-B15,
    //I16-I30,
    //N31-N45,
    //G45-G60,
    //O61-O75.
    private static int counter = 0;
    public static void main(String[] args) {
        int seed = 1;

        var streamB = Stream.iterate(seed, i -> i <= 15, i ->i + 1)
                .map(s -> "B" + s);
        //streamB.forEach(System.out::println);
        seed += 15;
        var streamI = Stream.iterate(seed, i -> i +1)
                .limit(15)
                .map(i -> "I" + i);
        //streamI.forEach(System.out::println);

        seed += 15;
        int currentSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (currentSeed + i));
        var streamN = Arrays.stream(oLabels);
        //streamN.forEach(System.out::println);

        seed += 15;
        var streamG = Stream
                .of("G46", "G47", "G48", "G49", "G50",
                        "G51", "G52", "G53", "G54", "G55",
                        "G56", "G57", "G58", "G59", "G60");
        //streamG.forEach(System.out::println);

        seed += 15;
        int rSeed = seed;
        var streamO = Stream.generate(Main::getCounter)
                .limit(15)
                .map(i -> "O" + (rSeed + i));
        //streamO.forEach(System.out::println);

        // concatenate
        var streamBI = Stream.concat(streamB, streamI);
        var streamNG = Stream.concat(streamN, streamG);
        var streamBING = Stream.concat(streamBI, streamNG);
        Stream.concat(streamBING, streamO).forEach(System.out::println);

        System.out.println("********************************************");

        Stream.generate(() -> new Random().nextInt(rSeed, rSeed + 15))
                .distinct()
                .limit(15)
                .map(i -> "O" + i)
                .sorted()
                .forEach(System.out::println);


    }

    private static int getCounter() {
        return counter++;
    }
}

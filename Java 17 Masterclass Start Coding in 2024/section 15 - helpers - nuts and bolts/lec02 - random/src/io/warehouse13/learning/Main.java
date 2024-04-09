package io.warehouse13.learning;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // using math random
        for (int i = 0; i < 10; i++)
            // common use of math random getting a range of numbers
            // int rand = (int) (Math.random() * (upper - lower)) + lower
            System.out.printf("%1$d = %1$c%n", (int) (Math.random() *26) + 65);

        System.out.println("**************************");
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
            System.out.printf("%1$d = %1$c%n", rand.nextInt(65, 91));


        System.out.println("**************************");
        for (int i = 0; i < 10; i++)
            System.out.printf("%1$d = %1$c%n", rand.nextInt('A', (int) 'Z' + 1));

        System.out.println("**************************");
        for (int i = 0; i < 10; i++)
            System.out.printf("%1$d%n", rand.nextInt());


        System.out.println("**************************");
        for (int i = 0; i < 10; i++)
            System.out.printf("%1$d%n", rand.nextInt(-10, 11)); // from -10 to 10

        System.out.println("**************************");
        rand.ints()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("**************************");
        rand.ints(0, 10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("**************************");
        // same as previous
        rand.ints(10, 0, 10)
                .forEach(System.out::println);

        System.out.println("**************************");
        // same as previous
        rand.ints(10)
                .forEach(System.out::println);

        // using seed
        long nanoTime = System.nanoTime();
        Random pseudoRandom = new Random(nanoTime);

        pseudoRandom.ints(10, 0, 10)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
        Random notReallyRandom = new Random(nanoTime);
        notReallyRandom.ints(10, 0, 10)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
    }
}

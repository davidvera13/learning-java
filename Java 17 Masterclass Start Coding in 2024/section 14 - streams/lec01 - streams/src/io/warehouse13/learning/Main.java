package io.warehouse13.learning;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // let's play bingo
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for(char c: "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i);
                //System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);
        for(int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("*****************");
        //List<String> firstOnes = bingoPool.subList(0, 15);
        // we make a copy of the list
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if (s.indexOf("G") == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.println("updated: " + updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("*****************");
        // we update the original list if we use sublist
        for(int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("*****************");
        // and using stream
        Stream<String> sorted = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf("G") == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted();
        // no code is executed until reaching terminal operation
                //.forEach(System.out::println);

        System.out.println("Nothing happened yet");
        // stream can be consumed only once
        sorted.forEach(System.out::println);
        //for(int i = 0; i < 15; i++) {
        //    System.out.println(bingoPool.get(i));
        //}
        System.out.println("*****************");
        String[] strings = { "one", "two", "three"};
        Arrays.stream(strings)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        Stream.of("Six", "five", "four")
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("*****************");
        var stream1 = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());

        var stream2 = Stream.of("Six", "five", "four")
                .map(String::toUpperCase);

        //Stream.concat(stream2, stream1)
        //        .forEach(System.out::println);
        Stream.concat(stream2, stream1)
                .map(s -> s.charAt(0) + "-" + s)
                .forEach(System.out::println);

        System.out.println("*****************");
        Map<Character, int[]> map = new LinkedHashMap<>();
        int bingoIndex = 1;
        for(char c: "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i -> i + labelNo);
            map.put(c, numbers);
            bingoIndex += 15;
        }

        map.entrySet()
                .stream()
                .map(e ->
                        e.getKey() + " has range " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);

        System.out.println("*****************");
        Random random = new Random();
        // generate 10 random values
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(System.out::println);


        System.out.println("*****************");
        // return the first 20 values
        IntStream.iterate(1, n -> n+1)
                .filter(Main::isPrime)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();


        // return the prime numbers < 100
        IntStream.iterate(1, n -> n+1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        // return the prime numbers < 100
        IntStream.iterate(1, n -> n <100, n -> n + 1)
                //.limit(20)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        // return the prime numbers < 100
        IntStream.range(0, 100)
                //.limit(20)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        // return the prime numbers <= 100
        IntStream.rangeClosed(0, 100)
                //.limit(20)
                .filter(Main::isPrime)
                .forEach(s -> System.out.print(s + " "));
    }


    public  static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;

        for (int divisor = 2; divisor < number; divisor ++)
            if (number % divisor == 0)
                return false;

        return true;
    }

}

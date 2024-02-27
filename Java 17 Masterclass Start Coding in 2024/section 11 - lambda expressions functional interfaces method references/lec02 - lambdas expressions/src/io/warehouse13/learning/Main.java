package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta", "echo"));

        // better than with index
        for (String letter: letters)
            System.out.println(letter);
        System.out.println("************");
        // using lambda
        letters.forEach(letter -> System.out.println(letter));

        System.out.println("************");
        // using method reference
        letters.forEach(System.out::println);

        System.out.println("************");
        // we can change it ! Variable used in lambda expression should be final or effectively final
        String prefix = "Nato";
        letters.forEach(str -> {
            char firstChar = str.charAt(0);
            System.out.println(prefix + " " + str + " means " + firstChar);
        });
        //prefix = "NATO";

        // functional interface
        int result1 = calculator((a, b) -> a + b, 2, 4);
        System.out.println(result1);
        int result2 = calculator(Integer::sum, 2, 4);
        System.out.println(result2);
        double result3 = calculator((a, b) -> a - b, 2.5, 4.4);
        System.out.println(result3);
        int result4 = calculator((a, b) -> {
            var c = a * b;
            return c;
        }, 2, 4);
        System.out.println(result4);
        int result5 = calculator((a, b) -> a / b, 4, 2);
        System.out.println(result5);

        String result6= calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "hello", "world");
        System.out.println(result6);

    }

    public static <T> T calculator(Operation<T> function, T val1, T val2) {
        T result = function.operate(val1, val2);
        System.out.println("Result is " + result);
        return result;
    }
}

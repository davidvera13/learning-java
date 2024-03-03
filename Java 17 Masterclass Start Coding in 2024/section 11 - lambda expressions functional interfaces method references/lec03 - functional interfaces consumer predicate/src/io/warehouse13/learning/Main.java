package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("********************");
        var coords = Arrays.asList(
                new Double[] { 47.2160, -95.2348},
                new Double[] { 29.1566, -89.2495},
                new Double[] { 35.1556, -89.2495}
        );

        // consumers
        coords.forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println("********************");
        BiConsumer<Double, Double> coordinates = (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], coordinates);

        System.out.println("********************");
        coords.forEach(coord -> processPoint(coord[0], coord[1], coordinates));

        System.out.println("********************");
        coords.forEach(coord -> processPoint(coord[0], coord[1], (lat, lng) ->
                System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));


        // predicated
        System.out.println("********************");
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta", "echo"));

        list.removeIf(letter -> letter.equalsIgnoreCase("BRAVO"));
        //letters.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
        System.out.println("********************");
        list.addAll(List.of("easy", "earnest", "ego"));
        list.forEach(System.out::println);
        System.out.println("********************");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);


    }

    public static <T> T calculator(BinaryOperator<T> function, T val1, T val2) {
        T result = function.apply(val1, val2);
        System.out.println("Result is " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    //public static <T> T calculator(Operation<T> function, T val1, T val2) {
    //    T result = function.operate(val1, val2);
    //    System.out.println("Result is " + result);
    //    return result;
    //}
}

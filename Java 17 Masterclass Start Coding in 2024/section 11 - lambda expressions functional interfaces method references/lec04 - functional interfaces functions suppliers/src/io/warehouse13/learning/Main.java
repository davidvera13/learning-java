package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // functional interface
        System.out.println("********************");
        var coords = Arrays.asList(
                new Double[] { 47.2160, -95.2348},
                new Double[] { 29.1566, -89.2495},
                new Double[] { 35.1556, -89.2495}
        );

        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta", "echo"));
        // unary argument
        System.out.println("********************");
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(System.out::println);

        System.out.println("********************");
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "Hello ");
        System.out.println(Arrays.toString(emptyStrings));

        // using apply
        Arrays.setAll(emptyStrings, (i) -> (i+1) +". ");
        System.out.println(Arrays.toString(emptyStrings));


        Arrays.setAll(emptyStrings, (i) -> (i+1) +". " + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            case 4, 5, 6, 7, 8, 9 -> "...";
            default -> "More than three";
        });
        System.out.println(Arrays.toString(emptyStrings));

        // using supplier
        String[] names = { "Albert", "Bob", "Charles", "Daniel", "Edwin", "George"};
        String[] randomizedList = randomlySelectedValues(
                15,
                names,
                () -> new Random().nextInt(0, names.length)); // supplier
        System.out.println(Arrays.toString(randomizedList));



    }

    public static <T> T calculator(BinaryOperator<T> function, T val1, T val2) {
        T result = function.apply(val1, val2);
        System.out.println("Result is " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(
       int count,
       String[] values,
       Supplier<Integer> integerSupplier) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++)
            selectedValues[i] = values[integerSupplier.get()];
        return selectedValues;
    }
    //public static <T> T calculator(Operation<T> function, T val1, T val2) {
    //    T result = function.operate(val1, val2);
    //    System.out.println("Result is " + result);
    //    return result;
    //}
}

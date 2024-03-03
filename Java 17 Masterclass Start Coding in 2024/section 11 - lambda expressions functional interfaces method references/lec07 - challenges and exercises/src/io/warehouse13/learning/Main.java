package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    private record Person(String firstName) {
        public String lastName(String str) {
            return firstName + " " + str.substring(0, str.indexOf(" "));
        }
    }
    private static final Random random = new Random();
    public static void main(String[] args) {
        // First, create an array of names, in mixed case, as you did in the Lambda Expression Challenge.
        // Create a list of Function interfaces, or alternately UnaryOperator, which will contain all the
        // operations you want executed on each name in your array.
        // Do something similar to what we did in the Lambda Expression challenge:
        // Make each name upper case,
        // Add a random middle initial,
        // Add a last name, which should be the reverse of the first.
        // In addition to this, add some custom transformations of your own.
        //  Use a mix of lambda expressions, and method references.
        // Create a method that takes the name array, and the function list, and applies each function to each name,
        // using the transform method on String, to do this.
        // All changes should be applied to the original array.
        // Make sure you explore as many transformations as you can, trying as many different types of method
        // references as you can think of.
        Person walter = new Person("Walter");
        String[] names = { "Anna", "Bob", "Charles", "Daniel", "Edwin", "Franck", "Greg"};
        List<UnaryOperator<String>> unaryOperators = new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('A', 'F') + ".",
                s -> s += " " + reverse(s, 0, s.indexOf(" ")),
                Main::reverse,
                String::new,
                //s -> new String("Howdy " + s),
                String::valueOf,
                walter::lastName,
                new Person("SKINNER")::lastName
        ));

        applyChanges(names, unaryOperators);
    }


    private static void applyChanges(
            String[] arr,
            List<UnaryOperator<String>> functions) {
        List<String> names = Arrays.asList(arr);
        functions.forEach(function -> {
            names.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(arr));
        });

    }

    // get random char
    public static char getRandomChar(char startChar, char endChar) {
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String reverse(String str, int startIndex, int endIndex) {
        return new StringBuilder(str.substring(startIndex, endIndex)).reverse().toString();
    }
    private static String reverse(String str) {
        return reverse(str, 0, str.length());
    }

}

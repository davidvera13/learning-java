package io.warehouse13.learning;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // with if statement
        int value = 1;

        // enhanced switch
        switch (value) {
            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("Value is 2");
            case 3 -> System.out.println("Value is 3");
            case 4 -> System.out.println("Value is 4");
            case 5, 6, 7 -> System.out.println("Value may be 5, 6 or 7");
            default -> System.out.println("Other value was provided");
        }

        char charValue = 'A';
        switch (charValue) {
            case 'A' -> System.out.println("A was found");
            case 'B' -> System.out.println("B was found");
            case 'C' -> System.out.println("C was found");
            case 'D', 'E', 'F' -> System.out.println("D, E or F was found");
            default -> System.out.println("Could not find character provided");
        }

        String month = "January";

        switch (month.toLowerCase(Locale.ROOT)) {
            case "january" -> System.out.println("jan");
            case "february" -> System.out.println("feb");
            case "march" -> System.out.println("mar");
            case "april" -> System.out.println("apr");
            default -> System.out.println("Other month");
        }

        printDayOfTheWeek(-1);
        printDayOfTheWeek(3);
        printDayOfTheWeek(13);
    }


    private static void printDayOfTheWeek(int day) {
        switch (day) {
            case 1 -> System.out.println("Sunday");
            case 2 -> System.out.println("Monday");
            case 3 -> System.out.println("Tuesday");
            case 4 -> System.out.println("Wednesday");
            case 5 -> System.out.println("Thursday");
            case 6 -> System.out.println("Friday");
            case 7 -> System.out.println("Saturday");
            default -> System.out.println("It's not a good day ... ");
        }
    }
}

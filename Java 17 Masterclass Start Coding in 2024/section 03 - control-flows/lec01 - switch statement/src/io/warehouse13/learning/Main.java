package io.warehouse13.learning;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // with if statement
        int value = 1;
        if(value == 1)
            System.out.println("Value is 1");
        else if(value == 2)
            System.out.println("Value is 2");
        else if(value == 3)
            System.out.println("Value is 3");
        else if(value == 4)
            System.out.println("Value is 4");
        else
            System.out.println("Other value was provided");

        // with switch
        switch (value) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3:
                System.out.println("Value is 3");
                break;
            case 4:
                System.out.println("Value is 4");
                break;
            case 5: case 6: case 7:
                System.out.println("Value may be 5, 6 or 7");
                break;
            default:
                System.out.println("Other value was provided");
                break;
        }

        char charValue = 'A';
        switch (charValue) {
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C':
                System.out.println("C was found");
                break;
            case 'D': case 'E': case 'F':
                System.out.println("D, E or F was found");
                break;
            default:
                System.out.println("Could not find character provided");
                break;
        }

        String month = "January";

        switch (month.toLowerCase(Locale.ROOT)) {
            case "january":
                System.out.println("jan");
                break;
            case "february":
                System.out.println("feb");
                break;
            case "march":
                System.out.println("mar");
                break;
            case "april":
                System.out.println("apr");
                break;
            default:
                System.out.println("Other month");
        }

        printDayOfTheWeek(-1);
        printDayOfTheWeek(3);
        printDayOfTheWeek(13);
    }


    private static void printDayOfTheWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("It's not a good day ... ");
                break;
        }
    }

    private static void printDayOfTheWeekIf(int day) {
        if(day == 1)
            System.out.println("Sunday");
        else if(day == 2)
                System.out.println("Monday");
        else if(day == 3)
            System.out.println("Tuesday");
        else if(day == 4)
            System.out.println("Wednesday");
        else if(day == 5)
            System.out.println("Thursday");
        else if(day == 6)
            System.out.println("Friday");
        else if(day == 7)
            System.out.println("Saturday");
        else
            System.out.println("It's not a good day ... ");
    }
}

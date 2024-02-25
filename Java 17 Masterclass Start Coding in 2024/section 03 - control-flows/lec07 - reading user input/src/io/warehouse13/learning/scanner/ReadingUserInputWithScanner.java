package io.warehouse13.learning.scanner;

import java.util.Scanner;

public class ReadingUserInputWithScanner {
    public static void main(String[] args) {

        int currentYear = 2024;

        try {
            // run java .\src\io\warehouse13\app\Lesson08readingUserInputWithScanner.java
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println("Ooops >> " + e.getMessage());
            System.out.println(getInputFromScanner(currentYear));
        }
    }

    public static String getInputFromConsole(int currentYear) {
        System.out.println("Read from console");
        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

    public static String getInputFromScanner(int currentYear) {
        System.out.println("Read from scanner");
        Scanner scanner = new Scanner(System.in);

        // String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi, What's your Name? ");
        String name = scanner.nextLine();

        System.out.println("Hi " + name + ", Thanks for taking the course!");

        // String dateOfBirth = System.console().readLine("What year were you born? ");
        System.out.println("What year were you born? ");
        boolean isValidDateOfBirth = false;
        int age = 0;

        do {
            System.out.println("Enter a year of birth >= " +
                    (currentYear - 125) + " and <= " + (currentYear));
            try {
                age = checkData(currentYear, scanner.nextLine());
                isValidDateOfBirth = age < 0 ? false : true;
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed!!! Try again.");
            }
        } while (!isValidDateOfBirth);

        return "So you are " + age + " years old";
    }

    public static int checkData(int currentYear, String dateOfBirth) {

        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if ((dob < minimumYear) || (dob > currentYear)) {
            return -1;
        }

        return (currentYear - dob);
    }
}
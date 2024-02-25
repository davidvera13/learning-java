package io.warehouse13.learning.console;

import java.time.LocalDate;
import java.util.Scanner;

public class ReadingUserInputWithConsole {
    public static void main(String[] args) {

        int currentYear = 2024;

        // run java .\src\io\warehouse13\app\Lesson07readingUserInput.java
        System.out.println(getInputFromConsole(currentYear));
    }

    public static String getInputFromConsole(int currentYear) {

        String name = System.console().readLine("Hi, What's your Name? ");
        System.out.println("Hi " + name + ", Thanks for taking the course!");

        String dateOfBirth = System.console().readLine("What year were you born? ");
        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }
}

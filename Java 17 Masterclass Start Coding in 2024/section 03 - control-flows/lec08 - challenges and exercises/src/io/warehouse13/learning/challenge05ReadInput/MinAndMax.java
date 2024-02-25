package io.warehouse13.learning.challenge05ReadInput;

import java.util.Scanner;

public class MinAndMax {
    // -Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered.
    //-Before the user enters the number, print the message Enter number:
    //-If the user enters an invalid number, break out of the loop and print the minimum and maximum number.
    //Hint:
    //-Use an endless while loop.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double max = 0;
        double min = 0;
        int loopCount = 0;

        while (true) {
            System.out.println("Enter a number, or any character to exit:");
            String nextEntry = scanner.nextLine();
            try {
                double validNum = Double.parseDouble(nextEntry);
                if (loopCount == 0 || validNum < min) {
                    min = validNum;
                }
                if (loopCount == 0 || validNum > max) {
                    max = validNum;
                }
                loopCount++;
            } catch (NumberFormatException nfe) {
                break;
            }
        }

        if (loopCount > 0) {
            System.out.println("min = " + min + ", max = " + max);
        } else {
            System.out.println("No valid data entered");
        }
    }
}

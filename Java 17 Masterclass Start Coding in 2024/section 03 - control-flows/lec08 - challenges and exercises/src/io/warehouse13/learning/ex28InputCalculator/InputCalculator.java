package io.warehouse13.learning.ex28InputCalculator;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage() {
        System.out.println("Type any numbers and press enter, when entering other char, sum and average will be returned");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;

        while (true) {
            boolean hasNextInt = scanner.hasNextInt();
            if (!hasNextInt) {
                break;
            }
            sum += scanner.nextInt();
            count++;
            scanner.nextLine();
        }
        long average = Math.round((double) sum / count);
        System.out.println("SUM = " + sum + " AVG = " + average);
        scanner.close();
    }
}

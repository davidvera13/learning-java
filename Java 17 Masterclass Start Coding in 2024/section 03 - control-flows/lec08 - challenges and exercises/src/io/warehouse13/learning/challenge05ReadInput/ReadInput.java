package io.warehouse13.learning.challenge05ReadInput;

import java.util.Scanner;

public class ReadInput {
    // read 5 numbers from console and sum the values before printing final result
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        int counter = 0;

        while(counter < 5) {
            int order = counter + 1;

            try {
                System.out.println("Enter number #" + order + ": ");
                String nextNumber = scanner.nextLine();
                counter++;
                double number = Double.parseDouble(nextNumber);
                sum += number;
            } catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                System.out.println("Invalid number");
            }
            //boolean hasNextInt = scanner.hasNextInt();
            //if(hasNextInt) {
            //    int value = scanner.nextInt();
            //    counter++;
            //    sum += value;
            //} else {
            //    System.out.println("Invalid number");
            //}
            //scanner.nextLine();
        }

        System.out.println("Sum = " + sum);

        scanner.close();
    }
}

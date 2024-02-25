package io.warehouse13.learning.ex21FactorPrinter;

public class FactorPrinter {
    public static void main(String[] args) {
        // → should print 1 2 3 6
        printFactors(6);
        // → should print 1 2 4 8 16 32
        printFactors(32);
        // → should print 1 2 5 10
        printFactors(10);
        // → should print "Invalid Value" since number is < 1
        printFactors(-1);
    }

    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        }
        String factorString = "";
        for (int i = 1; i <= number; i++) {
            while (number % i == 0) {
                factorString += i + " ";
                i++;
            }
        }
        System.out.println(factorString);
    }

}
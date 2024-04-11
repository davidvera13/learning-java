package io.warehouse13.learning;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalMain {
    public static void main(String[] args) {
        double policyAmount = 100_000_000;
        int beneficiaries = 3;
        float percentageFloat = 1.0f / beneficiaries;
        double percentage = 1.0 / beneficiaries;

        // RESULTS ARE DIFFERENT
        System.out.printf("Payout = %,.2f%n", policyAmount * percentageFloat);
        System.out.printf("Payout = %,.2f%n", policyAmount * percentage);

        double totalUsingFloat = policyAmount - ((policyAmount * percentageFloat) * beneficiaries);
        double total = policyAmount - ((policyAmount * percentage) * beneficiaries);

        // here results are also different
        System.out.printf("TotalUsingFloat: %,.2f%n", totalUsingFloat);
        System.out.printf("Total: %,.2f%n", total);

        // big decimal are required for financial calculations
        String[] tests = {"15.456", "8", "10000.000001", ".123"};
        BigDecimal[] bds = new BigDecimal[tests.length];
        Arrays.setAll(bds, i -> new BigDecimal(tests[i]));

        System.out.println("----------------------------------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        System.out.println("----------------------------------------------------");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("\n");



        // result output is weird. it is better to use string instead
        // Unpredictable 'new BigDecimal()' call
        double[] doubles = {15.456, 8, 10000.000001, .123};
        // Arrays.setAll(bds, i -> new BigDecimal(doubles[i]));
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i]));

        System.out.println("----------------------------------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        System.out.println("----------------------------------------------------");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("\n");

        // some issue: output is different: string constructor is more accurate
        BigDecimal test1 = new BigDecimal("1.1111122222333334444455555");
        BigDecimal test2 = BigDecimal.valueOf(1.1111122222333334444455555);
        System.out.println("----------------------------------------------------");
        System.out.printf("%-30s %-30s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        System.out.println("----------------------------------------------------");
        System.out.printf("%-30s %-30d %-8d %d %n",
                test1, test1.unscaledValue(), test1.scale(), test1.precision());
        System.out.printf("%-30s %-30d %-8d %d %n",
                test2, test2.unscaledValue(), test2.scale(), test2.precision());

    }
}

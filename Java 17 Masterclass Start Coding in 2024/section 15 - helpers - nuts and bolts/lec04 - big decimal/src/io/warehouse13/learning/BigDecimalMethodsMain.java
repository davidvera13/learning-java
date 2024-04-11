package io.warehouse13.learning;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class BigDecimalMethodsMain {
    public static void main(String[] args) {
        double[] doubles = {15.456, 8, 10000.000001, .125};
        BigDecimal[] bds = new BigDecimal[doubles.length];

        // Arrays.setAll(bds, i -> new BigDecimal(doubles[i]));
        Arrays.setAll(bds, i -> BigDecimal.valueOf(doubles[i]));

        System.out.println("----------------------------------------------------");
        System.out.printf("%-14s %-15s %-8s %s%n", "Value", "Unscaled Value", "Scale",
                "Precision");
        System.out.println("----------------------------------------------------");
        for (var bd : bds) {
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());

            bd = bd.setScale(2, RoundingMode.HALF_UP);
            System.out.printf("%-15s %-15d %-8d %d %n",
                    bd, bd.unscaledValue(), bd.scale(), bd.precision());
        }
        System.out.println("----------------------------------------------------");

        // do calculation
        //BigDecimal policyPayout = new BigDecimal("100_000_000");
        BigDecimal policyPayout = new BigDecimal("100000000.00");
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision());

        policyPayout = new BigDecimal("100e6");
        System.out.printf("%-15s %-15d %-8d %d %n",
                policyPayout, policyPayout.unscaledValue(), policyPayout.scale(), policyPayout.precision());

        // DIVISION
        System.out.println("Division");
        int beneficiaries = 3;
        System.out.println("----------------------------------------------------");
        BigDecimal percent32 = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL32);
        System.out.println(percent32);
        BigDecimal percent64 = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL64);
        System.out.println(percent64);
        BigDecimal percent128 = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries), MathContext.DECIMAL128);
        System.out.println(percent128);

        BigDecimal percentCustom60 = BigDecimal.ONE.divide(BigDecimal.valueOf(beneficiaries),
                new MathContext(60, RoundingMode.UP));
        System.out.println(percentCustom60);

        // MULTIPLY
        System.out.println("Multiplication");
        BigDecimal checkAmount = policyPayout.multiply(percentCustom60);
        System.out.printf("%.2f%n", checkAmount);
        System.out.printf("%-15s %-15d %-8d %d %n",
                checkAmount, checkAmount.unscaledValue(), checkAmount.scale(), checkAmount.precision());
        // using rounding mode
        checkAmount = checkAmount.setScale(2, RoundingMode.HALF_UP);
        System.out.printf("%-15s %-15d %-8d %d %n",
                checkAmount, checkAmount.unscaledValue(), checkAmount.scale(), checkAmount.precision());

        // check sum
        System.out.println("----------------------------------------------------");
        BigDecimal totalChecksAmount = checkAmount.multiply(BigDecimal.valueOf(beneficiaries));
        System.out.printf("Combined: %.2f%n", totalChecksAmount);
        System.out.println("Remaining = " + policyPayout.subtract(totalChecksAmount));


        System.out.printf("%-15s %-15d %-8d %d %n",
                totalChecksAmount, totalChecksAmount.unscaledValue(), totalChecksAmount.scale(), totalChecksAmount.precision());
    }
}

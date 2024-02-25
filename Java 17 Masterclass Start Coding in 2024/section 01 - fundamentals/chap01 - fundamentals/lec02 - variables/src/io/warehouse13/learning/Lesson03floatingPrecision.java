package io.warehouse13.learning;

import org.w3c.dom.ls.LSOutput;

public class Lesson03floatingPrecision {
    public static void main(String[] args) {
        int intNumber = 5;
        float floatNumber = 5;
        double doubleNumber = 5;

        // decimal point handling
        System.out.println("Int division :" + (intNumber / 3));
        System.out.println("float division :" + (floatNumber / 3));
        System.out.println("double division :" + (doubleNumber / 3));

        // use case : convert kilos to pounds
        System.out.println("Weight converter");
        double numberOfPounds = 200d;
        double convertedKg = numberOfPounds * 0.45359237d;
        System.out.println("Converted kilograms! " + convertedKg);
    }

}

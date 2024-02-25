package io.warehouse13.learning.v1;

import java.util.Scanner;

public class ArrayResize {
    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {
        // rosizing an array is possible but too complex
        System.out.println("Enter 10 integers");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("Enter 12 integers");
        getInput();
        printArray(baseData);
    }

    private static void resizeArray() {
        int[] original = baseData;
        baseData = new int[12];
        for (int i = 0; i < original.length; i++)
            baseData[i] = original[i];
    }

    private static void printArray(int[] baseData) {
        for (int i = 0; i < baseData.length; i++)
            System.out.print(baseData[i] + " ");
        System.out.println();
    }

    private static void getInput() {
        for (int i = 0; i < baseData.length; i++)
            baseData[i] = s.nextInt();

    }
}

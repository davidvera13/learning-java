package io.warehouse13.learning;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int intValue = 50;
        int[] intArray = new int[10];
        // count starts at position 0 => index 5 = 6th position

        intArray[5] = 50;
        intArray[0] = 22;
        intArray[1] = 66;

        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println("\n********************");

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);
        System.out.println("\n********************");


        // array of 10 elements
        int[] intValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // iterate the array
        for (int value : intValues) {
            System.out.print(value + " ");
        }

        System.out.println("\n********************");
        int[] anotherIntArray = new int[10];
        for (int i = 0; i < anotherIntArray.length; i++) {
            anotherIntArray[i] = (int) Math.pow(i, 2);
        }

        for (int i = 0; i < anotherIntArray.length; i++) {
            System.out.println("#" + i + " => " + anotherIntArray[i]);
        }
        System.out.println("\n********************");
        for (int element : anotherIntArray) {
            System.out.print(element + " ");
        }

        System.out.println(Arrays.toString(anotherIntArray));
        Object objectVariable = anotherIntArray;
        if (objectVariable instanceof int[]) {
            System.out.println("objectVariable is really an int array");
        }

        System.out.println("Using method call");
        printArray(anotherIntArray);

        System.out.println("\n********************");
        int[] integers = getIntegers(5);
        for (int i = 0; i < integers.length; i++) {
            System.out.println("#" + i + " => " + integers[i]);
        }

        System.out.println("\n********************");
        System.out.println("Average is " + getAverage(integers));


        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = anotherIntArray;

        for (int i = 0; i < objectArray.length; i++) {
            System.out.println("#" + i + " => " + objectArray[i]);
        }
    }

    private static double getAverage(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (sum / arr.length);
    }

    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
}

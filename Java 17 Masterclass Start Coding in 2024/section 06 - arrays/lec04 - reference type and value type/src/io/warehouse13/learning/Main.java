package io.warehouse13.learning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // both variable have same value
        // value types: each variable holds the value
        int intValue = 12;
        int intValue2 = intValue;
        System.out.println("intValue  = " + intValue);
        System.out.println("intValue2 = " + intValue2);
        intValue2++;
        System.out.println("intValue  = " + intValue);
        System.out.println("intValue2 = " + intValue2);
        intValue++;
        System.out.println("intValue  = " + intValue);
        System.out.println("intValue2 = " + intValue2);


        System.out.println("*****************");

        // reference types: both are pointing to the same object, not to the data itself
        int[] intArray = new int[5];
        int[] arr = intArray;

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(arr));

        intArray[0] = 12;
        intArray[1] = 13;
        intArray[2] = 15;
        intArray[3] = 17;
        intArray[4] = 22;

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(arr));

        arr[0] = 987;
        arr[1] = 657;
        arr[2] = 11;
        arr[3] = 0;
        arr[4] = 13;

        // both arrays are modified
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(arr));

        modifyArray(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(arr));

        arr = new int[] { 2, 5, 6, 6, 9};
        modifyArray(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(arr));
    }

    private static void modifyArray(int[] arr) {
        arr[0] = 2;
        // it references to a new array, so it won't work
        arr = new int[] { 1, 2, 3, 4, 5};
    }
}

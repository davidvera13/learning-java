package io.warehouse13.learning.ex43ReverseArray;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        System.out.println("The initial array is: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("The reversed array is: " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        int maxIndex = arr.length - 1;
        int halfLength = arr.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = arr[i];
            arr[i] = arr[maxIndex - i];
            arr[maxIndex - i] = temp;
        }
    }
}

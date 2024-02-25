package io.warehouse13.learning.ex42ArrayMinimumElement;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    public static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Define the array size: ");
        int[] array = readElements(scanner.nextInt());
        return findMin(array);
    }

    private static int[] readElements(int elt) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[elt];
        for (int i = 0; i < elt; i++) {
            System.out.println("Please enter a number.");
            while (true) {
                try {
                    array[i] = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input, please enter a number.");
                }
                scanner.nextLine();
            }
        }
        return array;
    }

    private static int findMin(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
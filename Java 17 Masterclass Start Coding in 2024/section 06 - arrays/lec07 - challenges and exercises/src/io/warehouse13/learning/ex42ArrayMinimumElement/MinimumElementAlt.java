package io.warehouse13.learning.ex42ArrayMinimumElement;

import java.util.Scanner;

public class MinimumElementAlt {

    public static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list of integers: ");
        int s = scanner.nextInt();

        return s;
    }

    public static int[] readElements(int element){
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[element];
        for(int i = 0; i < element; i++ ){
            values[i] = scanner.nextInt();

        }
        return values;
    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int el : array) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }
}
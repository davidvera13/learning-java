package io.warehouse13.learning.ex42ArrayMinimumElement;

public class Main {
    public static void main(String[] args) {
        System.out.println("Solution 1: ");
        System.out.println("The min of the input entered is: " + MinimumElement.readInteger());

        System.out.println("Solution 2: ");
        System.out.print("Define the array size: ");
        int size = MinimumElementAlt.readInteger();
        int[] arr = MinimumElementAlt.readElements(size);
        int min = MinimumElementAlt.findMin(arr);
        System.out.println("Min value : " + min);

    }
}

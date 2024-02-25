package io.warehouse13.learning.ex41SortingArray;

public class Main {

    public static void main(String[] args) {
        System.out.println("Entrer 5 valeurs");
        int[] arr = SortedArray.getIntegers(5);
        int[] sorted = SortedArray.sortIntegers(arr);
        SortedArray.printArray(sorted);
    }
}

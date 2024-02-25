package io.warehouse13.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] originalArray = new String[] { "first", "second", "third"};
        var originalList = Arrays.asList(originalArray);
        System.out.println(originalList);
        System.out.println("*************");
        originalList.set(0, "One");
        System.out.println("list > " + originalList);
        System.out.println("arrays > " + Arrays.toString(originalArray));

        System.out.println("*************");
        originalList.sort(Comparator.naturalOrder());
        System.out.println("list > " + originalList);
        System.out.println("arrays > " + Arrays.toString(originalArray));


        //UnsupportedOperationException
        //originalList.remove(0);
        //originalList.add("fourth");

        List<String> newList = Arrays.asList("Sunday", "Monday", "Thuesday");
        System.out.println(newList);

    }
}

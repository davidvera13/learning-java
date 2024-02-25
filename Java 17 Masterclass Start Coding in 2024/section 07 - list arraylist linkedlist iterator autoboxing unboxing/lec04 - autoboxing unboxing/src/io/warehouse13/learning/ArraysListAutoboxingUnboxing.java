package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysListAutoboxingUnboxing {


    public static void main(String[] args) {
        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));

        System.out.println(wrapperArray[0].getClass().getName());

        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));

        var setList = getList(1, 2, 3, 4, 6);
        System.out.println(setList);

        var ourList = List.of(1, 2, 3, 4, 5);
        System.out.println(ourList);

    }

    private static ArrayList<Integer> getList(int... varargs) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i : varargs)
            aList.add(i);
        return aList;
    }
}
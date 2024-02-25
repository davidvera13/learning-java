package io.warehouse13.learning;

import java.util.Arrays;

public class ArrMultiDimension {
    public static void main(String[] args) {
        int [][] arr2dim = new int[4][4];
        arr2dim[1] = new int[] {10, 20, 30};
        System.out.println(Arrays.deepToString(arr2dim));

        Object[] anyArr = new Object[3];
        System.out.println(Arrays.toString(anyArr));
        anyArr[0] = new String[] { "a", "b", "c"};

        System.out.println(Arrays.deepToString(anyArr));
        System.out.println("****************");
        anyArr[1] = new String [][] {
                {"1", "2"},
                {"4", "13", "25"},
                {"0", "1", "1", "2", "3", "5", "8"},
                {"3", "14", "157", "9"}
        };
        System.out.println(Arrays.deepToString(anyArr));
        System.out.println("****************");

        anyArr[2] = new int[2][2][2];
        // anyArr[2] = "I'll throw ClassCastException...";
        System.out.println(Arrays.deepToString(anyArr));
        System.out.println("****************");

        for (Object elt: anyArr) {
            System.out.println("Element type:  " + elt.getClass().getSimpleName());
            System.out.println("Element value: " + elt);
            System.out.println(Arrays.deepToString((Object[]) elt));
        }

    }
}

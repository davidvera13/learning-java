package io.warehouse13.learning;

import java.util.Arrays;

public class Arr2Dimension {
    public static void main(String[] args) {
        // 2 dimensional array
        int [][] arr2dim = new int[4][4];
        System.out.println(Arrays.toString(arr2dim));
        System.out.println("arr2dim.length -> " + arr2dim.length);

        for (int[] outer: arr2dim)
            System.out.println(Arrays.toString(outer));

        System.out.println("**************");
        for(int i = 0; i < arr2dim.length; i++) {
            var innerArr = arr2dim[i];
            for (int j = 0; j < innerArr.length; j++) {
                innerArr[j] = (i*10) + (j+1);
                System.out.println("(" + i + "," + j + ") -> " + innerArr[j]);
            }
        }

        //System.out.println("**************");
        //for(var outer: arr2dim) {
        //    for (var inner: outer)
        //        System.out.println(inner);
        //}
    }
}

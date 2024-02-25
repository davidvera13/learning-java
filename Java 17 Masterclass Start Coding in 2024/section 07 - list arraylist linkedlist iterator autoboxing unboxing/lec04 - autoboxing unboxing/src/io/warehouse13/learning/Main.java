package io.warehouse13.learning;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String[] strings = new String[10];
        int[] ints = new int[10];
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Some String");
        System.out.println(stringArrayList);

        // must use primitive class (int Wrapper is Integer)
        // ArrayList<int> generate error

        // solution 1: create a new class - it works but it's messy
        ArrayList<IntClass> intClassArrayList = new ArrayList<>();
        intClassArrayList.add(new IntClass(64));
        System.out.println(intClassArrayList);

        // solution 2: using autoboxing ie Wrapper class
        // wrapper examples
        Integer integer = new Integer(123);
        System.out.println(integer);

        // autoboxing sample
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(13);

        for(int i = 0; i <= 10; i++)
            // Unnecessary boxing
            integerArrayList.add(Integer.valueOf(i));

        for(int i = 0; i <= 10; i++)
            // Unnecessary unboxing
            System.out.println("#" + i + " => " +integerArrayList.get(i).intValue());


        // java updated: remove unnecessary unboxing
        Integer otherInteger = 234;
        System.out.println(otherInteger);
        ArrayList<Integer> anotherIntArrayList = new ArrayList<>();

        for(int i = 0; i <= 10; i++) {
            anotherIntArrayList.add(i);
        }

        for(int i = 0; i <= 10; i++) {
            System.out.println("#" + i + " => " +anotherIntArrayList.get(i));
        }

        ArrayList<Double> dblValues = new ArrayList<>();
        for(double d = 0; d <= 10; d+= 0.5) {
            dblValues.add(d);
        }
        for(int i = 0; i < dblValues.size(); i++) {
            System.out.println("#" + i + " value : " + dblValues.get(i));
        }
        Double resultBoxed = getLiteralDoublePrimitive();
        System.out.println(resultBoxed);
        double resultUnboxed = getDoubleObject();
        System.out.println(resultUnboxed);

    }

    private static Double getDoubleObject() {

        return Double.valueOf(100.00);
    }

    private static double getLiteralDoublePrimitive() {

        return 100.0;
    }
}


class IntClass {
    private int intValue;

    public IntClass(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}

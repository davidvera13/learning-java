package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        int maxMinusFive = Integer.MAX_VALUE - 5;
        // result to overflow but no exception
        for (int j = 0, id = maxMinusFive; j < 10; id++, j++) {
            System.out.printf("Assigning id %,d%n", id);
        }
        System.out.println("*************");
        // result to overflow with exception thrown
        //for (int j = 0, id = maxMinusFive; j < 10; id = Math.incrementExact(id), j++) {
        //    System.out.printf("Assigning id %,d%n", id);
        //}

        // absolute value
        System.out.println(Math.abs(-50));
        // integer overflow return negative value
        System.out.println(Math.abs(Integer.MIN_VALUE));
        //System.out.println(Math.absExact(Integer.MIN_VALUE));
        System.out.println(Math.abs((long) Integer.MIN_VALUE));

        // max value
        System.out.println("Max value = " + Math.max(-10, 10));
        System.out.println("Max value = " + Math.max(-10.0000002, 10.001));
        System.out.println("Max value = " + Math.max(-10.0000002, 10.001f));
        System.out.println("Max value = " + Math.max(-10.0000002d, 10.001d));

        // round
        System.out.println("Round down : " + Math.round(10.2));
        System.out.println("Round up : " + Math.round(10.8));
        System.out.println("Round 10.5 ? : " + Math.round(10.5));

        // ceil & floor
        System.out.println("floor : " + Math.floor(10.8));
        System.out.println("Ceil : " + Math.ceil(10.2));

        // sqr root
        System.out.println("Square root 100 = " + Math.sqrt(100));
        System.out.println("2 to the third power(2*2*2) = " + Math.pow(2, 3));
        System.out.println("10 to the fifth power(10*10*10*10*10) = " + Math.pow(10, 5));

        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

    }
}

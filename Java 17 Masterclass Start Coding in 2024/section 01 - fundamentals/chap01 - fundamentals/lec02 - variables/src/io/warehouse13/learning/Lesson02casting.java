package io.warehouse13.learning;

public class Lesson02casting {
    public static void main(String[] args) {

        // not mandatory apparently
        byte byteValue = (byte) (Byte.MAX_VALUE / 2);
        System.out.println(byteValue);

        short shortValue = (short) (Short.MIN_VALUE / 2);
        System.out.println(shortValue);
    }
}

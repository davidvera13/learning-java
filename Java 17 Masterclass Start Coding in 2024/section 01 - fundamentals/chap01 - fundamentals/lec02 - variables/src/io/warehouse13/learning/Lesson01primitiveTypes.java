package io.warehouse13.learning;

public class Lesson01primitiveTypes {
    public static void main(String[] args) {
        // byte
        System.out.println("Byte");
        byte minByte = Byte.MIN_VALUE; // -128
        byte maxByte = Byte.MAX_VALUE; //
        System.out.println("Byte min value: " + minByte);
        System.out.println("Byte max value: " + maxByte);
        System.out.println("*****************************************");

        // short
        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.println("Short min value: " + minShort);
        System.out.println("Short max value: " + maxShort);
        System.out.println("*****************************************");

        // int
        System.out.println("int");
        int minInteger = Integer.MIN_VALUE;
        int maxInteger = Integer.MAX_VALUE;
        int intMaxOverflow = maxInteger + 1;
        int intMinOverflow = minInteger - 1;
        System.out.println("Overflow max error: " + intMaxOverflow);
        System.out.println("Underflow min error: " + intMinOverflow);
        System.out.println("*****************************************");

        // long
        System.out.println("long");
        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.println("Long min value: " + minLong);
        System.out.println("Long max value: " + maxLong);
        long longMaxOverflow = minLong + 1L;
        long longMinOverflow = maxLong - 1L;
        System.out.println("Overflow max error: " + longMaxOverflow);
        System.out.println("Underflow min error: " + longMinOverflow);
        System.out.println("*****************************************");

        // float
        System.out.println("float");
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println("Float min value: " + minFloat);
        System.out.println("Float max value: " + maxFloat);
        float floatMaxOverflow = minFloat + 1f;
        float floatMinOverflow = maxFloat - 1f;
        System.out.println("Overflow max error: " + floatMaxOverflow);
        System.out.println("Underflow min error: " + floatMinOverflow);
        System.out.println("*****************************************");


        // double
        System.out.println("double");
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("Double min value: " + minDouble);
        System.out.println("Double max value: " + maxDouble);
        double doubleMaxOverflow = minDouble + 1d;
        double doubleMinOverflow = maxDouble - 1d;
        System.out.println("Overflow max error: " + doubleMaxOverflow);
        System.out.println("Underflow min error: " + doubleMinOverflow);
        System.out.println("*****************************************");

        // float error: double is provided by default
        // float floatNumber = 5.25;
        // requires cast or adding f
        // float floatNumber = 5.25f;
        float floatNumber = (float) 5.25;
        double doubleNumber = 5.25;

        System.out.println(floatNumber);
        System.out.println(doubleNumber);

        // boolean: true / false
        System.out.println("Boolean");
        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println(isTrue);
        System.out.println(isFalse);
        // age between 0 and 30
        int age = (int) (Math.random() * 30);
        boolean isOverTwenty = age > 20;

        System.out.println(isOverTwenty);
        System.out.println("*****************************************");

        // char
        System.out.println("Chars");
        char singleChar = 'C';
        System.out.println(singleChar);

        char unicodeChar = '\u0044';
        System.out.println(unicodeChar);

        char copyright = '\u00A9';
        System.out.println(copyright);

        // specific case : String is not a primitive
        String someString = "Hello how are you ? I'm a String";
        System.out.println("My String is:  " + someString);

        someString = someString + " and this is more string";
        System.out.println("My String is:  " + someString);

        someString += "\u00A9 2019";
        System.out.println("My String is:  " + someString);

        // tricky
        String numberString = "2550.25";
        double anotherDouble = 234.34d;

        numberString += anotherDouble;
        System.out.println(numberString);
    }
}

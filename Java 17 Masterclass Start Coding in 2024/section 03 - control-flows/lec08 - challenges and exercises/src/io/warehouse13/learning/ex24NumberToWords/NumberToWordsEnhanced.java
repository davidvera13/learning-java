package io.warehouse13.learning.ex24NumberToWords;

public class NumberToWordsEnhanced {
    public static void main(String[] args) {
        // should print "One Two Three".
        numberToWords(123);
        // should print "One Zero One Zero".
        numberToWords(1010);
        // should print "One Zero Zero Zero".
        numberToWords(1000);
        // should print "Invalid Value" since the parameter is negative.
        numberToWords(-12);
    }

    public static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            int lastDigit = number % 10;
            reverse *= 10;
            reverse += lastDigit;
            number /= 10;
        }
        return reverse;
    }


    public static int getDigitCount(int number) {
        int count = 0;
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;

    }


    public static void numberToWords(int number) {
        int newNum = 0;
        newNum = reverse(number);
        int reversedNum = newNum;
        int lastDig = 0;

        if (newNum < 0) {
            System.out.println("Invalid Value");
        }
        if (number == 0) {
            System.out.println("Zero");
        }
        while (newNum != 0) {
            lastDig = newNum % 10;
            switch (lastDig) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }
            newNum /= 10;
        }
        int a = getDigitCount(reversedNum);
        int b = getDigitCount(number);
        while (a - b != 0) {
            a++;
            System.out.println("Zero");
        }

    }
}
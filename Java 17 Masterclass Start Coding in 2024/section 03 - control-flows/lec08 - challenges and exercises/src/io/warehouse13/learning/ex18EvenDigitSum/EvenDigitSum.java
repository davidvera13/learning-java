package io.warehouse13.learning.ex18EvenDigitSum;

public class EvenDigitSum {
    public static void main(String[] args) {
        // → should return 20 since 2 + 4 + 6 + 8 = 20
        System.out.println(getEvenDigitSum(123456789));;
        // → should return 4 since 2 + 2 = 4
        System.out.println(getEvenDigitSum(252));;
        // → should return -1 since the number is negative
        System.out.println(getEvenDigitSum(-22));;
    }

    public static int getEvenDigitSum ( int number) {
        int sum = 0;
        if (number < 0) {
            return -1;
        }
        while (number!=0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sum = sum + lastDigit;
            }
            number = number / 10;
        }
        return sum;
    }
}

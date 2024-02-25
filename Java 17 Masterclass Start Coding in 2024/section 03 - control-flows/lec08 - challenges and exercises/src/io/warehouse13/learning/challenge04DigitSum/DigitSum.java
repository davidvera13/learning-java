package io.warehouse13.learning.challenge04DigitSum;

public class DigitSum {
    public static void main(String[] args) {
        // should return 8
        System.out.println("The sum of the digits in number 125 is " + sumDigits(125));
        System.out.println("The sum of the digits in number -125 is " + sumDigits(-125));
        System.out.println("The sum of the digits in number 4 is " + sumDigits(4));
        System.out.println("The sum of the digits in number 32123 is " + sumDigits(32123));
    }
    private static int sumDigits(int number) {
        if(number < 10)
            return -1;

        // while loop
        int sum = 0;
        // least digit
        // 125 => 125 / 10 = 12 => 12 * 1+ = 120 => 125 - 120 = 5
        while (number > 0) {
            // extract the least significant digit
            int digit = number % 10; // remain of division by 10 (last number)
            sum+= digit;
            // drop least significant digit
            number /= 10;
        }
        return sum;
    }
}

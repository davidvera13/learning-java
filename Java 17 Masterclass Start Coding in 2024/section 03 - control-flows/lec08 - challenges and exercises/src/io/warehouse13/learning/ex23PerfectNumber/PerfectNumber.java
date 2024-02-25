package io.warehouse13.learning.ex23PerfectNumber;

public class PerfectNumber {
    public static void main(String[] args) {
        // should return true since its proper divisors are 1, 2, 3 and the sum is 1 + 2 + 3 = 6
        System.out.println(isPerfectNumber(6));
        // should return true since its proper divisors are 1, 2, 4, 7, 14 and the sum is 1 + 2 + 4 + 7 + 14 = 28
        System.out.println(isPerfectNumber(28));
        // should return false since its only proper divisor is 1 and the sum is 1 not 5
        System.out.println(isPerfectNumber(5));
        // should return false since the number is < 1
        System.out.println(isPerfectNumber(-1));
    }
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sum = 0, remainder;
        for (int i=1; i<number/2+1; i++) {
            remainder = number % i;
            sum += remainder == 0? i: 0;
        }
        return number == sum;
    }
}

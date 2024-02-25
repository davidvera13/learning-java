package io.warehouse13.learning.ex22GreatestCommonDivisor;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        // should return 5 since both can be divided by 5 without a remainder
        System.out.println(getGreatestCommonDivisor(25, 15));
        // should return 6 since both can be divided by 6 without a remainder
        System.out.println(getGreatestCommonDivisor(12, 30));
        // should return -1 since the first parameter is < 10
        System.out.println(getGreatestCommonDivisor(9, 18));
        // should return 9 since both can be divided by 9 without a remainder
        System.out.println(getGreatestCommonDivisor(81, 153));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        }
        int gcd = 0;
        while (gcd == 0) {
            int remainder = first % second;
            if (remainder == 0) {
                gcd= second;
                return gcd;
            }
            first = second;
            second = remainder;
        }
        return 1;
    }
}
package io.warehouse13.learning.ex26LargestPrime;

public class LargestPrime {
    public static void main(String[] args) {
        // should return 7 since 7 is the largest prime (3 * 7 = 21)
        System.out.println(getLargestPrime (21));
        // should return 31 since 31 is the largest prime (7 * 31 = 217)
        System.out.println(getLargestPrime (217));
        // should return -1 since 0 does not have any prime numbers
        System.out.println(getLargestPrime (0));
        // should return 5 since 5 is the largest prime (3 * 3 * 5 = 45)
        System.out.println(getLargestPrime (45));
        // should return -1 since the parameter is negative
        System.out.println(getLargestPrime (-1));

    }
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        }
        int factor = 0;
        while(true) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0 && i < number) {
                    factor = i;
                    break;
                }
                if(i == number) {
                    return number;
                }
            }
            number /= factor;
        }
    }
}

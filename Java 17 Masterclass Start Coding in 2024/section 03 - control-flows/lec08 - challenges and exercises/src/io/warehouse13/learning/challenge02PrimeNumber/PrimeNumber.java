package io.warehouse13.learning.challenge02PrimeNumber;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(13));
        System.out.println(isPrime(6));

        int count = 0;
        for(int i=10; i <= 50; i++) {
            if(isPrime(i)) {
                count++;
                System.out.println(i + " is a prime number");

            } else {
                System.out.println(i + " is not a prime number");
            }
            if (count == 10) {
                System.out.println("Exiting for loop");
                break;
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n==1)
            return false;

        for(int i = 2; i <= n/2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isPrimeVariant(int n) {
        if (n==1)
            return false;

        for(int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

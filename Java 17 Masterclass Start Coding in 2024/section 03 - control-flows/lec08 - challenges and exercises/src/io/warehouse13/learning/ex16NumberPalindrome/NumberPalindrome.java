package io.warehouse13.learning.ex16NumberPalindrome;

public class NumberPalindrome {
    public static void main(String[] args) {
        // → should return true
        if(isPalindrome(-1221))
            System.out.println("-1221 is a palindrome");
        // → should return true
        if(isPalindrome(707))
            System.out.println("-1221 is a palindrome");

        // → should return false because reverse is 21211 and that is not equal to 11212.
        if(isPalindrome(11212))
            System.out.println("-11212 is a palindrome");
        else
            System.out.println("-11212 is NOT a palindrome");

    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int singleDigit;
        int originalNumber = number;

        while (number != 0) {
            singleDigit = number % 10;
            reverse = (reverse * 10) + singleDigit;
            number /= 10;
        }
        return originalNumber == reverse;
    }
}

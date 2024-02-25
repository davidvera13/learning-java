package io.warehouse13.learning.ex19SharedDigit;

public class SharedDigit {
    public static void main(String[] args) {
        // → should return true since the digit 2 appears in both numbers
        System.out.println(hasSharedDigit(12, 23));;
        // → should return false since 9 is not within the range of 10-99
        System.out.println(hasSharedDigit(9, 99));
        // → should return true since the digit 5 appears in both numbers
        System.out.println(hasSharedDigit(15, 55));
    }
    public static boolean hasSharedDigit(int nb1, int nb2) {

        if ((nb1 < 10) || (nb1 > 99) || (nb2 < 10) || (nb2 > 99)) {
            return false;
        }
        int nb1Digit1 = nb1 % 10;
        int nb1Digit2 = nb1 / 10;
        int nb2Digit1 = nb2 % 10;
        int nb2Digit2 = nb2 / 10;
        return (nb1Digit1 == nb2Digit1) || (nb1Digit1 == nb2Digit2) || (nb1Digit2==nb2Digit1) || (nb1Digit2 == nb2Digit2);
    }
}

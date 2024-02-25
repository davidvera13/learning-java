package io.warehouse13.learning.ex20LastDigitChecker;

public class LastDigitChecker {
    public static void main(String[] args) {
        // → should return true since 1 is the rightmost digit in numbers 41 and 71
        System.out.println(hasSameLastDigit (41, 22, 71));
        // → should return true since 2 is the rightmost digit in numbers 32 and 42
        System.out.println(hasSameLastDigit (23, 32, 42));
        // → should return false since 9 is not within the range of 10-1000
        System.out.println(hasSameLastDigit (9, 99, 999));

        // → should return true since 10 is within the range of 10-1000
        System.out.println(isValid(10));
        // → should return true since 468 is within the range of 10-1000
        System.out.println(isValid(468));
        // → should return false since 1051 is not within the range of 10-1000
        System.out.println(isValid(1051));

    }
    public static boolean hasSameLastDigit(int x, int y, int z){
        if((x<10 || x >1000) || (y<10 || y >1000) || (z<10 || z >1000)){
            return false;
        }
        return ((x%10 == y%10) || (y%10 == z%10) || (z%10 == x%10));
    }
    public static boolean isValid(int a){
        if (a<10 || a>1000 ){
            return false;
        } else {
            return true;
        }
    }
}

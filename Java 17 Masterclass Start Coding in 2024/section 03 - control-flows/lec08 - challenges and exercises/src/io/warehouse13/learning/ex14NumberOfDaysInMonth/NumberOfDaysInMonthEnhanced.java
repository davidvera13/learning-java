package io.warehouse13.learning.ex14NumberOfDaysInMonth;

public class NumberOfDaysInMonthEnhanced {
    public static void main(String[] args) {
        // →  should return false since the parameter is not in the range (1-9999)
        System.out.println(isLeapYear(-1600));
        // → should return true since 1600 is a leap year
        System.out.println(isLeapYear(1600));
        // → should return false since 2017 is not a leap year
        System.out.println(isLeapYear(2017));
        // → should return true because 2000 is a leap year
        System.out.println(isLeapYear(2000));
        // → should return 31 since January has 31 days.
        System.out.println(getDaysInMonth(1, 2020));
        // → should return 29 since February has 29 days in a leap year and 2020 is a leap year.
        System.out.println(getDaysInMonth(2, 2020));
        // → should return 28 since February has 28 days if it's not a leap year and 2018 is not a leap year.
        System.out.println(getDaysInMonth(2, 2018));
        // → should return -1 since the parameter month is invalid.
        System.out.println(getDaysInMonth(-1, 2020));
        // → should return -1 since the parameter year is outside the range of 1 to 9999.
        System.out.println(getDaysInMonth(1, -2020));
    }
    public static int getDaysInMonth(int month, int year) {
        if ((month < 1 || month > 12) || (year < 1 || year > 9999)) {
            return -1;
        }
        switch (month) {
            case 2 -> {
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            }
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            default -> {
                return 30;
            }
        }
    }
    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year > 0 && year <= 9999) {
            if (year % 400 == 0) {
                isLeap = true;
            } else if ((year % 100 != 0) && (year % 4 == 0)){
                isLeap = true;
            }
        }
        return isLeap;
    }
}
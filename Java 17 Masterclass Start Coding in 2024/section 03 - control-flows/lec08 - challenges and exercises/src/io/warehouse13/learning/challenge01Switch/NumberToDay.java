package io.warehouse13.learning.challenge01Switch;

public class NumberToDay {
    public static void main(String[] args) {
        int day = getRandomNumber(0, 8);

        switch (day) {
            case 0 -> System.out.println(day + " is Sunday");
            case 1 -> System.out.println(day + " is Monday");
            case 2 -> System.out.println(day + " is Tuesday");
            case 3 -> System.out.println(day + " is Wednesday");
            case 4 -> System.out.println(day + " is Thursday");
            case 5 -> System.out.println(day + " is Friday");
            case 6 -> System.out.println(day + " is Saturday");
            default -> System.out.println(day + " is not a day");
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

package io.warehouse13.learning;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = DayOfTheWeek.FRIDAY;
        System.out.println(dayOfTheWeek);
        System.out.printf("Name is %s, ordinal value is = %d%n", dayOfTheWeek.name(), dayOfTheWeek.ordinal());

        for(int i = 0; i < 10; i++) {
            DayOfTheWeek rand = getRandomDay();
            System.out.printf("Name is %s, ordinal value is = %d%n", rand.name(), rand.ordinal());
            switchDayOfTheWeek(rand);
            if(rand == DayOfTheWeek.FRIDAY)
                System.out.println("Waow it's friday");
        }


        for (Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static DayOfTheWeek getRandomDay() {
        int rand = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();
        return allDays[rand];
    }

    public static void switchDayOfTheWeek(DayOfTheWeek dayOfTheWeek) {
        int weekDayInt = dayOfTheWeek.ordinal() + 1;
        switch (dayOfTheWeek) {
            case SUNDAY -> System.out.println(">> Sunday is day " + weekDayInt);
            case MONDAY -> System.out.println(">> Monday is day " + weekDayInt);
            case TUESDAY -> System.out.println(">> Tuesday is day " + weekDayInt);
            case WEDNESDAY -> System.out.println(">> Wednesday is day " + weekDayInt);
            case THURSDAY -> System.out.println(">> Thursday is day " + weekDayInt);
            case FRIDAY -> System.out.println(">> Friday is day " + weekDayInt);
        }
    }
}

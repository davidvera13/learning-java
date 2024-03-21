package io.warehouse13.learning;

import java.util.*;

public class Main {
    enum WeekDay {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    public static void main(String[] args) {
        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(
                WeekDay.MONDAY,
                WeekDay.TUESDAY,
                WeekDay.THURSDAY,
                WeekDay.FRIDAY
        ));

        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        // RegularEnumSet: bit vectors:
        // 0 means the value is not in the set.
        // regular enum set max length is 64bits, enum can have 64 values
        // we have a JumboEnumSet if we have more than 64 values
        System.out.println(annsDaysSet.getClass().getSimpleName());
        annsDaysSet.forEach(System.out::println);

        System.out.println("**********************************");
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        allDaysSet.forEach(System.out::println);

        System.out.println("**********************************");
        Set<WeekDay> newPersonDay = EnumSet.complementOf(annsDaysSet);
        newPersonDay.forEach(System.out::println);

        System.out.println("**********************************");
        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaysSet);
        anotherWay.removeAll(annsDaysSet);
        anotherWay.forEach(System.out::println);

        System.out.println("**********************************");
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        businessDays.forEach(System.out::println);


        System.out.println("**********************************");
        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(
                WeekDay.FRIDAY, new String[] { "John", "Purdey", "Gambit", "Emma"}
        );
        employeeMap.put(
                WeekDay.MONDAY, new String[] { "John", "Emma", "Tara"}
        );

        employeeMap.forEach((key, value) -> System.out.println(key + ": " + Arrays.toString(value)));
    }

}

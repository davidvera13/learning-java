package io.warehouse13.learning;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateMain {
    public static void main(String[] args) {
        // immutable
        LocalDate today = LocalDate.now();
        System.out.println("today localDate (YYYY-mm-DD): " + today);

        LocalDate five5 = LocalDate.of(2024, 5, 5);
        System.out.println("5th of may date v1: " + five5);

        // same output
        LocalDate mayFifth = LocalDate.of(2024, Month.MAY, 5);
        System.out.println("5th of may date v2: " + mayFifth);

        LocalDate day125 = LocalDate.ofYearDay(2022, 125);
        System.out.println("5th of may date v3: " + day125);

        LocalDate mayFifthStr = LocalDate.parse("2022-05-05");
        System.out.println("5th of may date v4: " + mayFifthStr);

        System.out.println("Year : " + mayFifthStr.getYear());
        System.out.println("Month: " + mayFifthStr.getMonth());
        System.out.println("Month value: " + mayFifthStr.getMonthValue());
        System.out.println("Days of year: " + mayFifthStr.getDayOfYear());
        System.out.println("Days of week: " + mayFifthStr.getDayOfWeek());

        System.out.println("Year chrono field: " + mayFifthStr.get(ChronoField.YEAR));
        System.out.println("Month chrono field: " + mayFifthStr.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("Day of year chrono field: " + mayFifthStr.get(ChronoField.DAY_OF_YEAR));
        System.out.println("Day of month chrono field: " + mayFifthStr.get(ChronoField.DAY_OF_MONTH));
        System.out.println("Day of week chrono field: " + mayFifthStr.get(ChronoField.DAY_OF_WEEK));

        System.out.println("*******************************");
        System.out.println("Updating date: creates a temporary LocalDate object");
        System.out.println(mayFifthStr.withYear(2000));
        System.out.println(mayFifthStr.withMonth(3));
        System.out.println(mayFifthStr.withDayOfMonth(4));
        System.out.println(mayFifthStr.withDayOfYear(125));

        System.out.println(mayFifthStr.with(ChronoField.DAY_OF_YEAR, 194));
        System.out.println(mayFifthStr.withYear(2000).withMonth(8).withDayOfMonth(15));

        System.out.println(mayFifthStr.withYear(1975).withMonth(1).withDayOfMonth(14));
        System.out.println("After changes nothing is updated " + mayFifthStr);

        System.out.println("*******************************");
        System.out.println("Adding / removing year, months, days...");
        var mayFifthPlusYears = mayFifthStr.plusYears(3);
        System.out.println("+ 3 years: " + mayFifthPlusYears);
        var mayFifthPlusMonths = mayFifthStr.plusMonths(18);
        System.out.println("+ 18 months: " + mayFifthPlusMonths);
        var mayFifthPlusWeeks = mayFifthStr.plusWeeks(15);
        System.out.println("+ 15 weeks: " + mayFifthPlusWeeks);
        var mayFifthPlusDays = mayFifthStr.plusDays(15);
        System.out.println("+ 16 days: " + mayFifthPlusDays);
        var mayFifthPlusChronoUnit = mayFifthStr.plus(3, ChronoUnit.CENTURIES);
        System.out.println("+ 3 centuries: " + mayFifthPlusChronoUnit);


        var mayFifthMinusYears = mayFifthStr.minusYears(3);
        System.out.println("- 3 years: " + mayFifthMinusYears);
        var mayFifthMinusMonths = mayFifthStr.plusMonths(18);
        System.out.println("- 18 months: " + mayFifthMinusMonths);
        var mayFifthMinusWeeks = mayFifthStr.minusWeeks(15);
        System.out.println("- 15 weeks: " + mayFifthMinusWeeks);
        var mayFifthMinusDays = mayFifthStr.plusDays(15);
        System.out.println("- 15 days: " + mayFifthMinusDays);
        var mayFifthMinusChronoUnit = mayFifthStr.minus(3, ChronoUnit.CENTURIES);
        System.out.println("- 3 centuries: " + mayFifthMinusChronoUnit);

        System.out.println("*******************************");
        System.out.println("May 5th > today ? " + mayFifthStr.isAfter(today));
        System.out.println("today > May 5th ? " + mayFifthStr.isBefore(today));

        System.out.println("May 5th > today ? " + mayFifthStr.compareTo(today));
        System.out.println("today > May 5th ? " + today.compareTo(mayFifthStr));

        System.out.println("today > now ? " + today.compareTo(
                ChronoLocalDate.from(LocalDateTime.now())));

        System.out.println("today > now ? " + today.equals(
                ChronoLocalDate.from(LocalDateTime.now())));

        System.out.println("Leap year ?");
        System.out.println(today.isLeapYear());
        System.out.println(today.minusYears(1).isLeapYear());
        System.out.println(today.minusYears(2).isLeapYear());
        System.out.println(today.minusYears(3).isLeapYear());
        System.out.println(today.minusYears(4).isLeapYear());

        System.out.println("*******************************");
        mayFifthStr.datesUntil(mayFifthStr.plusDays(7))
                .forEach(System.out::println);

        System.out.println("*******************************");
        mayFifthStr.datesUntil(mayFifthStr
                        .plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);

    }
}

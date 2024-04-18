package io.warehouse13.learning;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.format.DateTimeFormatter.*;

public class Main {
    private record Employee(String name, Locale locale, ZoneId zoneId) {
        public Employee(String name, Locale locale, String zoneId) {
            this(name, locale, ZoneId.of(zoneId));
        }

        public Employee(String name, String locale, String zoneId) {
            this(name, Locale.forLanguageTag(locale), ZoneId.of(zoneId));
        }

        String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
            return "%s [%s]: %s".formatted(name, zoneId, zdt.format(dtf.localizedBy(locale)));
        }
    }
    public static void main(String[] args) {
        // Imagine you work for a company that has employees from around the world, and you need to find an hour of time
        // to schedule two employees to meet.
        // The meeting should be on a work day, Monday through Friday, and between the hours of 7 am and 9 pm (meaning
        // the meeting should not be scheduled any later than 8 pm) for either employee.
        // One of the employees is on the East Coast of the United States, the other is in Sydney, Australia.
        // Print all the possible hours in the upcoming 10 day range, ignoring the current day, when these two employees
        // could potentially meet together.
        // Print the date and time of each possible hour, for both zones, using the employee's locale.
        //The example output on this slide, demonstrates what one possible hour would look like, and the dates formatted
        // to the employee's locale.
        //Include the week day in the output, and the hour using am or pm, rather than a 24 hour format.
        //Jane [America/New_York] : Wednesday, June 14, 2023, 5:00 PM <---> Joe [Australia/Sydney] : Thursday, 15 June
        // 2023, 7:00 am

        // setup
        Employee jane = new Employee("Jane", Locale.US, "America/New_York");
        // Employee john = new Employee("John", "en-AU", "Australia/Sydney");
        Employee john = new Employee("John", "en-AU", "Australia/Eucla");

        // how may hours of difference  ?
        ZoneRules janesRules = jane.zoneId().getRules();
        ZoneRules johnsRules = john.zoneId().getRules();

        System.out.println(jane + " -> " + janesRules);
        System.out.println(john + " -> " + johnsRules);

        ZonedDateTime janeNow = ZonedDateTime.now(jane.zoneId);
        ZonedDateTime johnNow = ZonedDateTime.of(janeNow.toLocalDateTime(), john.zoneId);

        long hoursBetween = Duration.between(johnNow, janeNow).toHours();
        // long minutesBetween = Duration.between(johnNow, janeNow).toMinutes();
        long minutesBetween = Duration.between(johnNow, janeNow).toMinutesPart();

        System.out.println("John is " + Math.abs(hoursBetween) +
                " hours " + Math.abs(minutesBetween) +
                " minutes " + ((hoursBetween < 0 ? " behind": " ahead"))) ;


        System.out.println("Joe in daylight savings? " +
                johnsRules.isDaylightSavings(johnNow.toInstant()) + " " +
                johnsRules.getDaylightSavings(johnNow.toInstant()) + ": " +
                johnNow.format(ofPattern("zzzz z")));

        System.out.println("Jane in daylight savings? " +
                janesRules.isDaylightSavings(janeNow.toInstant()) + " " +
                janesRules.getDaylightSavings(janeNow.toInstant()) + ": " +
                janeNow.format(ofPattern("zzzz z")));

        System.out.println("-----");
        int days = 10;
        var map = schedule(john, jane, days);
        DateTimeFormatter dtf = ofLocalizedDateTime(FormatStyle.FULL,
                FormatStyle.SHORT);

        for (LocalDate ldt : map.keySet()) {
            System.out.println(ldt.format(ofLocalizedDate(FormatStyle.FULL)));
            for (ZonedDateTime zdt : map.get(ldt)) {
                System.out.println("\t" +
                        jane.getDateInfo(zdt, dtf) + " <---> " +
                        john.getDateInfo(zdt.withZoneSameInstant(john.zoneId), dtf));
            }
        }
    }


    private static Map<LocalDate, List<ZonedDateTime>> schedule(
            Employee first,
            Employee second,
            int days) {

        Predicate<ZonedDateTime> rules = zdt ->
                zdt.getDayOfWeek() != DayOfWeek.SATURDAY
                        && zdt.getDayOfWeek() != DayOfWeek.SUNDAY
                        && zdt.getHour() >= 7 && zdt.getHour() < 21;

        LocalDate startingDate = LocalDate.now().plusDays(2);
        return startingDate.datesUntil(startingDate.plusDays(days + 1))
                .map(dt -> dt.atStartOfDay(first.zoneId))
                .flatMap(dt -> IntStream.range(0, 24).mapToObj(dt::withHour))
                .filter(rules)
                .map(dtz -> dtz.withZoneSameInstant(second.zoneId()))
                .filter(rules)
                .collect(
                        Collectors.groupingBy(ZonedDateTime::toLocalDate,
                                TreeMap::new, Collectors.toList()));
    }
}

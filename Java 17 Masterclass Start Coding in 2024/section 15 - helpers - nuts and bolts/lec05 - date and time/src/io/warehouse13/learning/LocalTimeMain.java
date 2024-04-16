package io.warehouse13.learning;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeMain {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime sevenAM = LocalTime.of(7, 0);
        System.out.println("sevenAm: " + sevenAM);

        LocalTime halfPastSevenAM = LocalTime.of(7, 30);
        System.out.println("halfPastSevenAM: " + halfPastSevenAM);

        LocalTime halfPastSevenPM = LocalTime.of(19, 30);
        System.out.println("halfPastSevenPM: " + halfPastSevenPM);

        LocalTime halfPastSevenAMWithSeconds = LocalTime.of(7, 30, 45);
        System.out.println("halfPastSevenWithSeconds: " + halfPastSevenAMWithSeconds);

        LocalTime sevenPM = LocalTime.parse("19:00");
        System.out.println("sevenPM: " + sevenPM);

        LocalTime sevenPMWithSeconds = LocalTime.parse("19:00:13");
        System.out.println("sevenPM: " + sevenPMWithSeconds);

        LocalTime sevenPMWithSecondsAndMillis = LocalTime.parse("19:00:13.1000");
        System.out.println("sevenPM: " + sevenPMWithSecondsAndMillis);

        //LocalTime missingZero = LocalTime.parse("9:00:13");
        //System.out.println("sevenPM: " + missingZero);

        // 1 if PM
        System.out.println("sevenPM.get(ChronoField.AMPM_OF_DAY) > " + sevenPM.get(ChronoField.AMPM_OF_DAY));
        System.out.println("sevenPMWithSecondsAndMillis.get(ChronoField.AMPM_OF_DAY) > " + sevenPMWithSecondsAndMillis.get(ChronoField.AMPM_OF_DAY));

        // 0 if AM
        System.out.println("sevenAM.get(ChronoField.AMPM_OF_DAY) > " + sevenAM.get(ChronoField.AMPM_OF_DAY));
        System.out.println("halfPastSevenAM.get(ChronoField.AMPM_OF_DAY) > " + halfPastSevenAM.get(ChronoField.AMPM_OF_DAY));

        System.out.println("halfPastSevenPM.get(ChronoField.HOUR_OF_DAY) > " + halfPastSevenPM.get(ChronoField.HOUR_OF_DAY));

        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: Year
        // System.out.println("halfPastSevenPM.get(ChronoField.HOUR_OF_DAY) > " + halfPastSevenPM.get(ChronoField.YEAR));

        // Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Days
        // System.out.println(halfPastSevenPM.plus(1, ChronoUnit.DAYS));

         System.out.println(halfPastSevenPM.plus(24, ChronoUnit.HOURS));

        System.out.println("range");
        System.out.println("sevenAM.range(ChronoField.HOUR_OF_DAY) > " + sevenAM.range(ChronoField.HOUR_OF_DAY));
        System.out.println("sevenAM.range(ChronoField.MINUTE_OF_HOUR) > " + sevenAM.range(ChronoField.MINUTE_OF_HOUR));
        System.out.println("sevenAM.range(ChronoField.MINUTE_OF_DAY) > " + sevenAM.range(ChronoField.MINUTE_OF_DAY));
        System.out.println("sevenAM.range(ChronoField.SECOND_OF_MINUTE) > " + sevenAM.range(ChronoField.SECOND_OF_MINUTE));
        System.out.println("sevenAM.range(ChronoField.SECOND_OF_DAY) > " + sevenAM.range(ChronoField.SECOND_OF_DAY));

    }
}

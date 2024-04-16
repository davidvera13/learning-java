package io.warehouse13.learning;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime todayAndNow = LocalDateTime.now();
        System.out.println(todayAndNow);

        LocalDateTime may5thNoon = LocalDateTime.of(
                2022, 5, 5, 12, 0);

        // tR => 12 hours
        System.out.printf("%tD %tr %n", may5thNoon, may5thNoon);
        System.out.printf("%tF %1$tT %n", may5thNoon);
        System.out.println("using format > " + may5thNoon.format(DateTimeFormatter.ISO_WEEK_DATE));

        DateTimeFormatter df;
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("using format > " + may5thNoon.format(df));

        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println("using format > " + may5thNoon.format(df));


        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println("using format > " + may5thNoon.format(df));


        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("using format > " + may5thNoon.format(df));

        System.out.println("using format > " + may5thNoon.format(
                DateTimeFormatter.ofLocalizedDateTime(
                        FormatStyle.MEDIUM)));

        LocalDateTime may6Noon = may5thNoon.plusHours(24);
        System.out.println(may6Noon);

        System.out.println("using format > " + may6Noon.format(
                DateTimeFormatter.ofLocalizedDateTime(
                        FormatStyle.MEDIUM)));

    }
}

package io.warehouse13.learning;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class ZoneIdInstantMain {
    public static void main(String[] args) {
        // setting time zone
        System.setProperty("user.timezone", "America/Los_Angeles");
        // System.setProperty("user.timezone", "UTC");
        // zone id changed
        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of time zones: " + ZoneId.getAvailableZoneIds().size());
        System.out.println("*******************");
        System.out.println("List time zones");
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Europe"))
                .sorted()
                .map(ZoneId::of)
                //.forEach(System.out::println);
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldWay = new HashSet<>(Set.of(alternate));

        //jdk8Zones.removeAll(oldWay);
        //System.out.println(jdk8Zones);

        oldWay.removeAll(jdk8Zones);
        System.out.println(oldWay);

        // Exception in thread "main" java.time.zone.ZoneRulesException: Unknown time-zone ID: BET
        // ZoneId bet = ZoneId.of("BET");
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);

        // local date time is updated by property set
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        for(ZoneId z : List.of(
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/New_York"))) {
            DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(zoneFormat));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
        }

        Instant birthDateInstant = Instant.parse("2022-01-01T08:45:13Z");
        System.out.println("birthDateInstant > " + birthDateInstant);

        LocalDateTime dateOfBirth = LocalDateTime.ofInstant(birthDateInstant, ZoneId.systemDefault());
        System.out.println("dateOfBirth in LA Time > "
                + dateOfBirth.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dateOfBirthSydney = ZonedDateTime.ofInstant(birthDateInstant, ZoneId.of("Australia/Sydney"));
        System.out.println("dateOfBirth in Sydney Time > "
                + dateOfBirthSydney.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));


        ZonedDateTime dateOfBirthDefault = dateOfBirthSydney.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("dateOfBirth in default Time > "
                + dateOfBirthDefault.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));


        // using temporal adjuster
        ZonedDateTime firstOfMonth = ZonedDateTime.now()
                .with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.printf("First day of next month = %tD %n", firstOfMonth);

        Period timePast = Period.between(LocalDate.EPOCH, dateOfBirth.toLocalDate());
        System.out.println(timePast);// period returned in year

        Duration timeSince = Duration.between(Instant.EPOCH, dateOfBirth.toInstant(ZoneOffset.MAX));
        System.out.println(timeSince);// period of time calculated in minutes

        LocalDateTime dateOfBirth2 = dateOfBirth
                .plusYears(2)
                .plusMonths(3)
                .plusHours(11)
                .plusMinutes(21)
                .plusSeconds(44);


        System.out.println("dateOfBirth2 in default Time > "
                + dateOfBirth2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        Period timePast2 = Period.between(LocalDate.EPOCH, dateOfBirth2.toLocalDate());
        System.out.println(timePast2);// period returned in year

        Duration timeSince2 = Duration.between(Instant.EPOCH, dateOfBirth2.toInstant(ZoneOffset.MAX));
        System.out.println(timeSince2);// period of time calculated in minutes

        for(ChronoUnit unit: ChronoUnit.values()) {
            if(unit.isSupportedBy(LocalDate.EPOCH)) {
                long val = unit.between(LocalDate.EPOCH, dateOfBirth2.toLocalDate());
                System.out.println(unit + " past = " + val);
            } else {
                System.out.println("-- Not supported : " + unit);
            }
        }

        System.out.println("*****************************");
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC);
        for(ChronoUnit unit: ChronoUnit.values()) {
            if(unit.isSupportedBy(LocalDate.EPOCH)) {
                long val = unit.between(ldt, dateOfBirth2);
                System.out.println(unit + " past = " + val);
            } else {
                System.out.println("-- Not supported : " + unit);
            }
        }



    }
}

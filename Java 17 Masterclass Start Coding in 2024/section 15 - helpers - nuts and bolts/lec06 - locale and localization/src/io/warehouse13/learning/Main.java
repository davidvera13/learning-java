package io.warehouse13.learning;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println("Default Locale = " + Locale.getDefault());

        Locale en = new Locale("en");
        Locale enAU = new Locale("en", "AU");
        Locale enCA = new Locale("en", "CA");

        Locale enIN = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();

        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        List<Locale> locales = List.of(
                Locale.getDefault(), Locale.US, en, Locale.UK, enAU, enCA, enIN, enNZ);
        for (var locale: locales) {
            System.out.println(locale.getDisplayName() + " -> " +
                    LocalDateTime.now().format(dtf.withLocale(locale)));
        }


        DateTimeFormatter wDayMonth = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        LocalDate may5th = LocalDate.of(2020, 5, 5);
        System.out.println("*****************************");
        locales = List.of(
                Locale.CANADA,
                Locale.CANADA_FRENCH,
                Locale.FRANCE,
                Locale.GERMANY,
                Locale.TAIWAN,
                Locale.JAPAN,
                Locale.ITALY);
        for (var locale: locales) {
            System.out.println(locale.getDisplayName() + ": " +
                    locale.getDisplayName(locale) + " = \n\t" +
                    may5th.format(wDayMonth.withLocale(locale)));

            System.out.printf(locale, "\t%1$tA, %1$tB %1$te, %1$tY %n", may5th);
            System.out.print(String.format(locale, "\t%1$tA, %1$tB %1$te, %1$tY %n", may5th));

            NumberFormat decimalInfo = NumberFormat.getNumberInstance(locale);
            decimalInfo.setMaximumFractionDigits(6);
            System.out.println(decimalInfo.format(12345455.123456789));



            NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
            System.out.println(currency.format(555.555));

            Currency localCurrency = Currency.getInstance(locale);
            System.out.println(currency.format(555.555) + " [" +
                    localCurrency.getCurrencyCode() + "] " +
                    localCurrency.getDisplayName(locale) + "/" +
                    localCurrency.getDisplayName());
            System.out.println("----");
        }

        System.out.println();
        // Exception in thread "main" java.lang.NumberFormatException:
        // Character , is neither a decimal digit number, decimal point, nor "e" notation exponential mark.
        // BigDecimal loan = new BigDecimal("1,000.50");
        // System.out.println("Loan : " + loan);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the loan amount: ");
        // wo locale: 1,000.75 is working
        // with locale: 1076,25 will work
        scanner.useLocale(Locale.ITALY);
        BigDecimal myLoan = scanner.nextBigDecimal();
        NumberFormat decimalInfo = NumberFormat.getNumberInstance(Locale.ITALY);
        System.out.println("My Loan " + myLoan);
        System.out.println("My Loan " + decimalInfo.format(myLoan));
    }
}

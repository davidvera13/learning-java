package io.warehouse13.learning;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // formatted uses regex in java.util.Formatter class:
        // private static final String formatSpecifier
        //        = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])";
        // private static final Pattern fsPattern = Pattern.compile(formatSpecifier);
        String helloWorld = "%s %s".formatted("hello", "world");
        // same output
        String helloWorld2 = String.format("%s %s", "Hello", "World");
        System.out.println("Using string's formatted method : " + helloWorld);
        System.out.println("Using String.format()           : " + helloWorld2);

        String helloWorld3 = Main.format("%s %s%s", "Hello", "WORLD", "...");
        System.out.println("Using custom format method      : " + helloWorld3);
        String helloWorld4 = Main.format2("%s %s%s", "Hello", "WORLD", "...");
        System.out.println("Using custom format2 method     : " + helloWorld4);

        System.out.println("************************");
        String str = "Anyone can learn abc's, 123's and any regular expression";
        String replacement = "-";
        // patterns are case sensitive
        // if we use [] we consider ANY character between
        String[] patterns = {
                "abc",      // wil find the whole sequence abc
                "[abc]",    // will try to find any char from the array
                "a|b|c",    // will try to find a, b or c
                "ab|bc",    // will try to find ab or bc
                "123",      // wil find the whole sequence 123
                "[123]",    // will try to find any char from the array
                "A",
                "[A]",
                "[a-z]",        // will try to find any lower case letter
                "[A-Z]",        // will try to find any capital letter
                "[0-9]" ,       // will try to find any numerical value
                "[a-zA-Z]",     // will try to find any letter without considering case
                // using quantifiers : *, + ? { n }, { n, }, { m, n }
                "[A-Z]*",       // will try to find any capital letter
                "[0-9]*" ,      // won't replace all numerric value...
                "[0-9]+" ,      // will replace all numerric value...
                "[0-9]{2}" ,    // will try to replace the 2 first numbers
                "[a-zA-Z]*",    // will try to find any letter without considering case
                // using boundary ^ (match to start of text), $ (match to end of text) , \b (match to word)
                "[a-zA-Z]*$",    // will try to find any letter without considering case
                "[a-zA-Z]{3}",
                "[aA]ny\\b"
        };

        for(String pattern: patterns) {
            String output = str.replaceFirst(pattern, replacement);
            System.out.println("Pattern: " + pattern + " -> " + output);
        }

        // Methods that use Regular Expressions
        System.out.println("************************");
        // Song of the Witches in MacBeth, a Play by Shakespeare
        String paragraph = """
                Double, double toil and trouble;
                Fire burn and caldron bubble.
                Fillet of a fenny snake,
                In the caldron boil and bake
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and howlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble.
                """;

        String[] lines;
        String[] words;

        lines = paragraph.split("\n");
        System.out.println("This paragraph has " + lines.length + " lines");

        // line break match : \\R
        lines = paragraph.split("\\R");
        System.out.println("This paragraph has " + lines.length + " lines");

        words = paragraph.split("\\s");
        System.out.println("This paragraph has " + words.length + " words");

        System.out.println(paragraph.replaceAll("[a-zA-Z]+ble", "[GRUB]"));

        System.out.println("******************");
        Scanner scanner;

        scanner = new Scanner(paragraph);
        // \p{javaWhitespace}+
        System.out.println(scanner.delimiter());
        while (scanner.hasNext()) {
            String elt = scanner.next();
            System.out.println(elt);
        }

        System.out.println("******************");
        scanner = new Scanner(paragraph);
        // use a specific delimiter in scanner
        scanner.useDelimiter("\\R");
        System.out.println(scanner.delimiter());
        while (scanner.hasNext()) {
            String elt = scanner.next();
            System.out.println(elt);
        }

        System.out.println("******************");
        scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\R");
        scanner.tokens()
                .map(s -> Arrays.stream(s.split("\\s+")).count())
                .forEach(System.out::println);

        System.out.println("******************");
        scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\R");
        scanner.tokens()
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(s -> s.matches("[a-zA-Z]+ble"))
                .forEach(System.out::println);
        // return doubles, because other words ending with ble have punctuation
        System.out.println("******************");

        scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\R");
        scanner.tokens()
                // remove punctions
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(s -> s.matches("[a-zA-Z]+ble"))
                .forEach(System.out::println);

        System.out.println("******************");
        scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\p{javaWhitespace}+");
        // return first Double
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));
        // return second double
        System.out.println(scanner.findInLine("[a-zA-Z]+ble"));





                scanner.close();

    }

    private static String format(String regexp, String... args) {
        int index = 0;
        while (regexp.contains("%s")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }

        return regexp;
    }

    private static String format2(String regexp, String... args) {
        int index = 0;
        while (regexp.matches(".*%s.*")) {
            regexp = regexp.replaceFirst("%s", args[index++]);
        }

        return regexp;
    }
}

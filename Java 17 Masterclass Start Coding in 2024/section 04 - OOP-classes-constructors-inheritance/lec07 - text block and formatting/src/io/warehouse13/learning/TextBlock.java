package io.warehouse13.learning;

public class TextBlock {

    public static void main(String[] args) {

        String bulletIt = "Print a Bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";

        System.out.println(bulletIt);
        System.out.println("****************");

        String textBlock = """
                
                Print a Bulleted List:
                    \u2022 First Point
                        \u2022 Sub Point""";

        System.out.println(textBlock);
        System.out.println("****************");

        int age = 35;
        // %d is format specifier : replace d by age value
        // more on format specifiers: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Formatter.html
        System.out.printf("Your age is %d\n", age);
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = 2023 - age;
        // d is present 2 times, it replaces first param and second param of printf
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);
        // we can parse to float 2f is precision (2 numbers after comma)
        System.out.printf("Your age is %.2f%n", (float) age);

        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }

        // using string format
        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);
    }
}

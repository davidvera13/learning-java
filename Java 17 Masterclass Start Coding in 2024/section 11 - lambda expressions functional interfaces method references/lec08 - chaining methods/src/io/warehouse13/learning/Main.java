package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String name = "David";
        Function<String, String> upperCasing = String::toUpperCase;
        System.out.println(upperCasing.apply(name));

        Function<String, String> lastName = s -> s.concat(" Vera");
        Function<String, String> upperCasingLastName = upperCasing.andThen(lastName);
        System.out.println(upperCasingLastName.apply(name));

        upperCasingLastName = upperCasing.compose(lastName);
        System.out.println(upperCasingLastName.apply(name));

        Function<String, String[]> fun1 = upperCasing
                .andThen(s-> s.concat(" Vera"))
                .andThen(s -> s.split(" "));

        System.out.println(Arrays.toString(fun1.apply(name)));


        Function<String, String> fun2 = upperCasing
                .andThen(s-> s.concat(" Vera"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() + ",  " + s[0]);

        System.out.println(fun2.apply(name));

        Function<String, Integer> fun3 = upperCasing
                .andThen(s-> s.concat(" Vera"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(",", s))
                .andThen(String::length);

        System.out.println(fun3.apply(name));

        String[] names = { "Ann", "Bob", "Charles"};
        Consumer<String> consumer1 = s -> System.out.print(s.charAt(0));
        Consumer<String> consumer2 = System.out::println;

        Arrays.asList(names).forEach(consumer1
                .andThen(s -> System.out.print(" - "))
                .andThen(consumer2));

        // check conditions
        Predicate<String> pred1 = s -> s.equals("DAVID");
        Predicate<String> pred2 = s -> s.equalsIgnoreCase("david");
        Predicate<String> pred3 = s -> s.startsWith("d");
        Predicate<String> pred4 = s -> s.endsWith("e");


        // combining
        Predicate<String> combo1 = pred1.or(pred2);
        System.out.println("combo1: " + combo1.test(name));

        Predicate<String> combo2 = pred3.and(pred4);
        System.out.println("combo2: " + combo2.test(name));

        Predicate<String> combo3 = pred3.and(pred4).negate();
        System.out.println("combo3: " + combo3.test(name));

        // adding local record
        record Person(String firstName, String lastName) {}

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));

        persons.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        persons.forEach(System.out::println);

        System.out.println("------------------------------------");
        persons.sort(Comparator.comparing(Person::lastName));
        persons.forEach(System.out::println);

        System.out.println("------------------------------------");
        persons.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName));
        persons.forEach(System.out::println);

        System.out.println("------------------------------------");
        persons.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed());
        persons.forEach(System.out::println);
    }
}

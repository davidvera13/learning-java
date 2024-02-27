package src.io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " +  lastName;
        }
    }
    public static void main(String[] args) {

        // not a functional interface: more than 1 abstract method (we extend comparator)
        // @FunctionalInterface
        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")
        ));

        // before
        System.out.println(people);
        // creating anonymous class comparator
        //var lastNameComparator = new Comparator<Person>() {
        //    @Override
        //    public int compare(Person o1, Person o2) {
        //        return o1.lastName.compareTo(o2.lastName);
        //    }
        //};
        //people.sort(lastNameComparator);

        // using anonymous class comparator
        //people.sort(new Comparator<Person>() {
        //    @Override
        //    public int compare(Person o1, Person o2) {
        //        return o1.lastName.compareTo(o2.lastName);
        //    }
        //}

        // using lambda ...
        //people.sort((Comparator<Person>) (o1, o2) -> o1.lastName.compareTo(o2.lastName));
        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);

        // going further
        people.sort(Comparator.comparing(o -> o.lastName));
        System.out.println(people);

        // this is not an anonymous class: it can't be converted to lambda.
        // as we have more than 1 abstract method implemented
        var enhancedComparator = new EnhancedComparator<Person>() {
            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return (result == 0 ? secondLevel(o1, o2): result);
            }
        };
        System.out.println("using enhanced interface");
        people.sort(enhancedComparator);
        System.out.println(people);
    }
}

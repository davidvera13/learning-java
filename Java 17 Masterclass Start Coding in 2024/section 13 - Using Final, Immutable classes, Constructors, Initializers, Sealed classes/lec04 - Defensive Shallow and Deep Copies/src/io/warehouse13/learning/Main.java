package io.warehouse13.learning;

import java.util.Arrays;

record Person(String name, String dateOfBirth, Person[] kids) {

    public Person(Person p) {
        this(p.name, p.dateOfBirth(), p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Person joe = new Person("Joe", "01/01/1991", null);
        Person jim = new Person("Jim", "02/02/1992", null);
        Person jack = new Person("Jack", "03/03/1963", new Person[]{joe, jim});
        Person jane = new Person("Jane", "04/04/1964", null);
        Person jill = new Person("Jill", "05/05/1965", new Person[]{joe, jim});

        Person[] persons = { joe, jim, jack, jane, jill };
        // deep copy here is not required or useful
        // Person[] personsShallowCopy = Arrays.copyOf(persons, persons.length);
        Person[] personsShallowCopy = persons.clone();

        var jillKids = personsShallowCopy[4].kids();
        jillKids[1] = jane;
        for(int i = 0; i < persons.length; i++) {
            if (persons[i] == personsShallowCopy[i])
                System.out.println("Equal references: " + persons[i]);
        }


        // we made deep copty
        Person[] personsDeepCopy = new Person[5];
        // for(int i = 0; i < persons.length; i++) {
        //     //Person current = persons[i];
        //     //var kids = current.kids();
        //    //var kids = current.kids() == null ? null : Arrays.copyOf(current.kids(), current.kids().length);
        //    // personsDeepCopy[i] = new Person(current.name(), current.dateOfBirth(), kids) ;
        //    // because we have a constructor which takes a person object
        //    personsDeepCopy[i] = new Person(persons[i]);
        //}

        Arrays.setAll(personsDeepCopy, i -> new Person(persons[i]));
        System.out.println("Nothing should be printed here... references are not equals");
        for(int i = 0; i < persons.length; i++) {
            if (persons[i] == personsDeepCopy[i])
                System.out.println("Equal references: " + persons[i]);
            else
                System.out.println("...");
        }
        System.out.println("********************");
        System.out.println("For check, we have the same data but not referencing the same objects");
        System.out.println("persons[4]\t\t\t\t" + persons[4]);
        System.out.println("personsDeepCopy[4]\t\t" + personsDeepCopy[4]);
    }
}

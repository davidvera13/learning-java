package io.warehouse13.learning.app;

import io.warehouse13.learning.external.Child;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating objects");
        Parent parent = new Parent("Fox Mulder", "01/03/1976", 4);
        Child child = new Child();

        System.out.println("******************");
        System.out.println("Printing objects");
        System.out.println("parent: " + parent);
        System.out.println("parent: " + child);

        // record constructor
        Person joe = new Person("Joe", "01-04-1958");
        // to string is implicitly generated
        System.out.println(joe);

        Person joeCopy = new Person(joe);
        System.out.println(joeCopy);

        // enums
        System.out.println("******************");
        Generation genX = Generation.GEN_X;
        System.out.println(genX);

        System.out.println("******************");
        Generation genZ = Generation.GEN_Z;
        System.out.println(genZ);

    }
}

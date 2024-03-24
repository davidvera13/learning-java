package io.warehouse13.learning;

import io.warehouse13.learning.domain.Person;

public class Main {
    public static void main(String[] args) {
        Person jane = new Person("Jane", "01/12/1943");
        Person jim = new Person("Jim", "01/12/1947");
        Person joe = new Person("Joe", "04/07/1951");
        Person[] johnKids = { jane, jim, joe };

        // parent
        Person john = new Person("John", "01/06/1905", johnKids);
        System.out.println(john);
        // we can set the kids ... that could be a problem ...
        john.setKids(new Person[]{ new Person("Ann", "19/04/1928")});
        System.out.println(john);

        Person[] kids = john.getKids();
        kids[0] = jim;
        System.out.println(john);

        kids = null;
        // no effect ...
        System.out.println(john);
        john.setKids(kids);


        // let change parent name and update kids ... We should not be able to do this!
        // BAD PRACTICE : we can set any values and update them
        ////kids
        // Person jane = new Person();
        // jane.setName("Jane");
        // Person jim = new Person();
        // jim.setName("Jim");
        // Person joe = new Person();
        // joe.setName("Joe");
        //// parent
        // Person john = new Person();
        // john.setName("John");
        // john.setDateOfBirth("01/06/1905");
        // john.setKids(new Person[] {jane, jim, joe});
        // System.out.println(john);
        //// let change parent name and update kids ... We should not be able to do this!
        // john.setName("Jacob");
        // System.out.println(john);
        // john.setKids(new Person[]{new Person(), new Person()});
        // System.out.println(john);
    }
}

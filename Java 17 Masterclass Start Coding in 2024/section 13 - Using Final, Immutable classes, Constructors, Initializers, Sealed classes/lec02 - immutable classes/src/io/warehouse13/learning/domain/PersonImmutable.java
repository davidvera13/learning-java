package io.warehouse13.learning.domain;

import java.util.Arrays;

// create full immutable objects
// make instance fields private and final
// do not define any setters
// create defensive copies in getters
// use constructor or factory method to set data, making copies of mutable references data
// make class final or make all constructors private
public class PersonImmutable {
    // make instance fields private and final
    private final String name;
    private final String dateOfBirth;
    protected final PersonImmutable[] kids;

    //public Person() {
    //}

    public PersonImmutable(String name, String dateOfBirth) {
        this(name, dateOfBirth, null);
    }

    public PersonImmutable(String name, String dateOfBirth, PersonImmutable[] kids) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        // create defensive copies in getters (and constructors too)
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    // how to subclass an immutable class ? we implement a copy constructor.
    // A subclass should use this constructor
    protected PersonImmutable(PersonImmutable person) {
        this(person.getName(), person.getDateOfBirth(), person.getKids());
        //this.name = person.getName();
        //this.dateOfBirth = person.getDateOfBirth();
        //this.kids = person.getKids();
    }

    // do not define any setters
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // create defensive copies in getters
    public final PersonImmutable[] getKids() {
        // return kids;
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }


    @Override
    public String toString() {
        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", Date of birth = " + getDateOfBirth() + ", kids = " + kidString;
    }
}

package io.warehouse13.learning.domain;

import java.util.Arrays;

public class Person {
    private String name;
    private String dateOfBirth;
    private Person[] kids;

    //public Person() {
    //}

    public Person(String name, String dateOfBirth) {
        this(name, dateOfBirth, null);
    }

    public Person(String name, String dateOfBirth, Person[] kids) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.kids = kids;
    }

    // all getters and setters
    public String getName() {
        return name;
    }

    //public void setName(String name) {
    //    this.name = name;
    //}

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    //public void setDateOfBirth(String dateOfBirth) {
    //    this.dateOfBirth = dateOfBirth;
    //}

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", " + dateOfBirth + ", kids = " + kidString;
    }
}

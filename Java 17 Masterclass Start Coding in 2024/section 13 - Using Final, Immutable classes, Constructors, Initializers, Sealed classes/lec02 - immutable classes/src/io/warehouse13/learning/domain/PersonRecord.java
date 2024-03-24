package io.warehouse13.learning.domain;

import java.util.Arrays;

public record PersonRecord(
        String name,
        String dateOfBirth,
        PersonRecord[] kids) {

    public PersonRecord(String name, String dateOfBirth) {
        // let's consider we have placeholder of 20 kids
        this(name, dateOfBirth, new PersonRecord[20]);
    }

    @Override
    public String toString() {
        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
        return name + ", Date of birth = " + dateOfBirth + ", kids = " + kidString;

    }

    // make kinds array immutable:
    // fix:
    // kids[0] = jim;
    // kids[1] = new PersonRecord("Anna", "04/04/1936");
    @Override
    public PersonRecord[] kids() {
        return kids == null ? null: Arrays.copyOf(kids, kids.length);
    }
}


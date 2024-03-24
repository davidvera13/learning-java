package io.warehouse13.learning;

import io.warehouse13.learning.domain.PersonRecord;

public class MainRecord {
    public static void main(String[] args) {
        PersonRecord jane = new PersonRecord("Jane", "01/12/1943");
        PersonRecord jim = new PersonRecord("Jim", "01/12/1947");
        PersonRecord joe = new PersonRecord("Joe", "04/07/1951");
        PersonRecord[] johnKids = { jane, jim, joe };

        // parent
        PersonRecord john = new PersonRecord("John", "01/06/1905", johnKids);
        System.out.println(john);

        PersonRecord johnCopy = new PersonRecord("John", "01/06/1905");
        System.out.println(johnCopy);

        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jim;
        kids[1] = new PersonRecord("Anna", "04/04/1936");
        // recoreds are not immutable when using arrays or collections,
        // this issue can be fixes
        System.out.println(johnCopy);

        // if we UPDATE johnKids:
        johnKids[0] = new PersonRecord("Ann", "04/05/1936");
        System.out.println(john);


    }
}

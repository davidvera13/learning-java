package io.warehouse13.learning;

import io.warehouse13.learning.domain.HackerPersonOfInterest;
import io.warehouse13.learning.domain.LivingPerson;
import io.warehouse13.learning.domain.PersonImmutable;

public class MainImmutable {
    public static void main(String[] args) {
        PersonImmutable jane = new PersonImmutable("Jane", "01/12/1943");
        PersonImmutable jim = new PersonImmutable("Jim", "01/12/1947");
        PersonImmutable joe = new PersonImmutable("Joe", "04/07/1951");
        PersonImmutable[] johnKids = { jane, jim, joe };

        // parent
        PersonImmutable john = new PersonImmutable("John", "01/06/1905", johnKids);
        System.out.println(john);

        // can't add or modify
        PersonImmutable[] kids = john.getKids();
        kids[0] = jim;
        kids[1] = new PersonImmutable("Anna", "04/04/1936");
        System.out.println(john);
        johnKids[0] = new PersonImmutable("Ann", "04/05/1936");
        System.out.println(john);

        // 'PersonImmutable(io.warehouse13.learning.domain.PersonImmutable)' has protected access in 'io.warehouse13.learning.domain.PersonImmutable'
        // PersonImmutable johnCopy = new PersonImmutable(john);

        LivingPerson johnLivingPerson = new LivingPerson(john.getName(), john.getKids());
        System.out.println(johnLivingPerson);

        LivingPerson anne = new LivingPerson("Ann", null);
        johnLivingPerson.addKid(anne);

        System.out.println(johnLivingPerson);


        HackerPersonOfInterest johnCopy = new HackerPersonOfInterest(john);
        System.out.println(johnCopy);

        System.out.println("***********************");
        kids = johnCopy.getKids();
        kids[1] = anne;

        System.out.println(johnCopy);
        System.out.println(john);

    }
}

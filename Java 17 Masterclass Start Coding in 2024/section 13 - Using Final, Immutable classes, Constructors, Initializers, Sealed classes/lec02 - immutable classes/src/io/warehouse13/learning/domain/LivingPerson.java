package io.warehouse13.learning.domain;

import java.util.Arrays;

public class LivingPerson extends PersonImmutable{

    public LivingPerson(String name,PersonImmutable[] kids) {
        super(name, null, kids == null ? new PersonImmutable[10] : Arrays.copyOf(kids, 10));
    }

    public LivingPerson(PersonImmutable person) {
        super(person);
    }

    @Override
    public String getDateOfBirth() {
        return null;
    }

    public void addKid(PersonImmutable kid) {
        for(int i = 0; i < kids.length; i++) {
            if(kids[i] == null) {
                kids[i] = kid;
                break;
            }
        }
    }
}

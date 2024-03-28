package io.warehouse13.learning.external;

import io.warehouse13.learning.app.Parent;

import java.util.Random;

public class Child extends Parent {
    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    {
        if(siblings == 0)
            birthOrderString = "Only";
        else if(birthOrder == 1 )
            birthOrderString = "First";
        else if(birthOrder == siblings+1)
            birthOrderString = "Last";
         else
            birthOrderString = "Stuck in the middle";

        System.out.println("Child initializer: birthOrder = " + birthOrder +
                " - birthOrderString = " + birthOrderString);

    }
    public Child() {
        super("Walter Skinner", "04/05/1965", 5);
        System.out.println("In Parent Constructor");

    }

    // we can initialize propoerties in a final method
    private final int getBirthOrder() {
        if(siblings == 0) return 1;
        return new Random().nextInt(1, siblings + 2);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + birthOrderString + " child";
    }
}

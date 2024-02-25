package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Mammal;

public class Horse extends Mammal {

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    // we implement missing methods not implemented
    @Override
    public void makeNoise() {
        System.out.println(getExplicitType() + " is neighing");

    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds in the spring");
    }
}

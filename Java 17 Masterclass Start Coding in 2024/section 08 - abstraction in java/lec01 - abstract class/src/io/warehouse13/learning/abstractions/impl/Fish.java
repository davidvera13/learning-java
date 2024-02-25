package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Animal;

public class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print("# Fish.move() called " + speed + ": ");
        if(speed.equals("slowly"))
            System.out.println(getExplicitType() + " Just swimming");
        else
            System.out.println(getExplicitType() + " darting frantically");
    }

    @Override
    public void makeNoise() {
        System.out.print("# Fish.makeNoise() called: ");
        if (type.equals("Goldfish"))
            System.out.println("swish!");
        else
            System.out.println("splash!");
    }
}

package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Mammal;

//public class Dog extends Animal {
public class Dog extends Mammal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print("# Dog.move() called " + speed + ": ");
        if(speed.equals("slowly"))
            System.out.println(getExplicitType() + " walking");
        else
            System.out.println(getExplicitType() + " running");
    }

    @Override
    public void shedHair() {
        System.out.println("# Dog.shedHair() called: " + getExplicitType() + " shed hair all the time");
    }

    @Override
    public void makeNoise() {
        System.out.print("# Dog.makeNoise() called: ");
        if (type.equals("wolf"))
            System.out.println("Howling wolf...");
        else
            System.out.println("Barking at the moon...");
    }
}

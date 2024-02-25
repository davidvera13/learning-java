package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Animal;
import io.warehouse13.learning.abstractions.FlightEnabled;
import io.warehouse13.learning.abstractions.Trackable;

// single inheritance but implement many interfaces
public class Bird extends Animal implements FlightEnabled, Trackable {
    @Override
    public void move() {
        System.out.println("Flaps wings");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " is flying");
    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}

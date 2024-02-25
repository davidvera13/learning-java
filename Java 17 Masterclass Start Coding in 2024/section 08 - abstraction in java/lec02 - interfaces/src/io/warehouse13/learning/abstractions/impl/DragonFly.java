package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.FlightEnabled;

public record DragonFly(String name, String type) implements FlightEnabled {
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
}

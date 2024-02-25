package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.OrbitEarth;

public class Satellite implements OrbitEarth {
    // initial state
    FlightStages stage = FlightStages.GROUNDED;
    @Override
    public void achieveOrbit() {
        transition(getClass().getSimpleName() + " orbit achieved");
        //System.out.println("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition(getClass().getSimpleName() + " is taking off");
        //System.out.println(getClass().getSimpleName() + " is taking off");
    }

    @Override
    public void land() {
        transition(getClass().getSimpleName() + " is landing");
        //System.out.println(getClass().getSimpleName() + " is landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition(getClass().getSimpleName() + " is flying...Data collection while orbiting");
        //System.out.println(getClass().getSimpleName() + " is flying");
    }

    //@Override
    public void transition(String description) {
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}

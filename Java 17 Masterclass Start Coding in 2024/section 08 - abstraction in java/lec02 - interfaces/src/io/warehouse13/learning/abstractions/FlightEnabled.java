package io.warehouse13.learning.abstractions;

import io.warehouse13.learning.abstractions.impl.FlightStages;

public interface FlightEnabled {
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    // all methods here are abstract, no need to declare abstract, it's implicit.
    void takeOff();
    void land();
    void fly();

    // adding new class may change ALL classes that implement interface
    // before java8, it was required to implement the method.
    // since then, we have the interface extension method
    //FlightStages transition(FlightStages stages);

    default FlightStages transition(FlightStages stage) {
        // this.getClass().getName() is a new featyre
        //System.out.println("transition not implemented on " + getClass().getName());
        //return null;

        // we're using enum
        FlightStages next = stage.getNextStage();
        System.out.println(getClass().getSimpleName() + " transitioning from " + stage + " to " + next);
        return next;

    }
}

package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Trackable;

public enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED)
            System.out.println("monitoring " + this);
    }
    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }

}

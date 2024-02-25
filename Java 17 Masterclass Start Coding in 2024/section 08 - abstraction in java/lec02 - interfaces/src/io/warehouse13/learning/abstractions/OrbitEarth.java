package io.warehouse13.learning.abstractions;

import io.warehouse13.learning.abstractions.impl.FlightStages;

import java.util.Date;

public interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();

    // new feature! using static methods in interface
    private static void log(String description) {
        var today = new Date();
        System.out.println(">> " + today + ": " + description);
    }

    // be
    private void logStage(FlightStages stage, String description) {
        log(stage + " - " + description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages next = FlightEnabled.super.transition(stage);
        logStage(stage, " beginning transition to " + next);
        return next;
    }
}

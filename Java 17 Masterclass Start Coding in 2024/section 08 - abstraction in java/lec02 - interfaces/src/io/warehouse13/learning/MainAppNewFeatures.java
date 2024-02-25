package io.warehouse13.learning;

import io.warehouse13.learning.abstractions.FlightEnabled;
import io.warehouse13.learning.abstractions.OrbitEarth;
import io.warehouse13.learning.abstractions.Trackable;
import io.warehouse13.learning.abstractions.impl.Bird;
import io.warehouse13.learning.abstractions.impl.FlightStages;
import io.warehouse13.learning.abstractions.impl.Jet;
import io.warehouse13.learning.abstractions.impl.Satellite;

public class MainAppNewFeatures {
    public static void main(String[] args) {
        inFlight(new Jet());
        System.out.println("***************");
        inFlight(new Bird());
         System.out.println("***************");
        // OrbitEarth.log("Testing " + new Satellite());
        orbit(new Satellite());

    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        flier.land();
        if(flier instanceof Trackable tracked)
            tracked.track();
    }

    private static void orbit (OrbitEarth flier) {
        flier.takeOff();
        flier.fly();
        flier.land();
    }
}

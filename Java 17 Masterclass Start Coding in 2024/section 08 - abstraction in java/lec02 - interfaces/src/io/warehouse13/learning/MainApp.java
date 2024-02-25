package io.warehouse13.learning;

import io.warehouse13.learning.abstractions.Animal;
import io.warehouse13.learning.abstractions.FlightEnabled;
import io.warehouse13.learning.abstractions.Trackable;
import io.warehouse13.learning.abstractions.impl.Bird;
import io.warehouse13.learning.abstractions.impl.Jet;
import io.warehouse13.learning.abstractions.impl.Truck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        // bird can be assigned to different types
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
        //flier.move();
        //tracked.move();
        inFlight(flier);
        System.out.println("************");
        inFlight(bird);
        System.out.println("************");
        inFlight(new Jet());

        System.out.println("************");
        Trackable truck = new Truck();
        truck.track();

        System.out.println("************");
        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        System.out.println("************");
        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);

        // it's better to code through interface
        //List<FlightEnabled> bestFliers = new ArrayList<>();
        List<FlightEnabled> bestFliers = new LinkedList<>();
        bestFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

         triggerFliers(bestFliers);
         flyFliers(bestFliers);
         landFliers(bestFliers);
    }

    private static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.fly();
        flier.land();
        if(flier instanceof Trackable tracked)
            tracked.track();
    }

    // here we pass a list of fliers, we can use LinkedList instead of arraylist to call the method
    private static void triggerFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.land();
        }
    }
}

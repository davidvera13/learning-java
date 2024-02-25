package io.warehouse13.learning.ex38RoomComposition;

public class Main {
    public static void main(String[] args) {
        // create a single room of a house using composition
        // think about the things that should be included in the room
        // maybe physical parts of the house but furnitures as well
        // add at least one method to access an object via getter and
        // public method then add at least one method to hide the object e.g. not using
        // a getter

        Wall wall1 = new Wall("North");
        Wall wall2 = new Wall("South");
        Wall wall3 = new Wall("East");
        Wall wall4 = new Wall("West");

        Ceiling ceiling = new Ceiling(12, "White");

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedroom = new Bedroom("My Bedroom", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}

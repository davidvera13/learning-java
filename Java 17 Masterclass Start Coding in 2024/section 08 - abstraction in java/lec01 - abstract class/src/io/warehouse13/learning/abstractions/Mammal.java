package io.warehouse13.learning.abstractions;

public abstract class Mammal extends Animal {
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print("Mammal.move() called " + speed + ": ");
        System.out.println(getExplicitType() + "is currently " + (speed.equals("slowly") ? "walking": "running"));
    }

    public abstract void shedHair();
}

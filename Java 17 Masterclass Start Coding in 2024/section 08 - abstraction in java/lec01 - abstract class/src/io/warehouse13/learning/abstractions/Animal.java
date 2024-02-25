package io.warehouse13.learning.abstractions;

public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    // abstract methods that need to be implemented in subclasses
    public abstract void move(String speed);
    public abstract void makeNoise();

    // concrete method used in abstract class
    public final String getExplicitType() {
        return getClass().getSimpleName() + "(" + type + ")";
    }
}

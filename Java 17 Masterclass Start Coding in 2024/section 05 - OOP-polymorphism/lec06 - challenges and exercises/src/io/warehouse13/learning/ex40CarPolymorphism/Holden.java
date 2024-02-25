package io.warehouse13.learning.ex40CarPolymorphism;

public class Holden extends Car {

    public Holden (int cylinders, String name) {
        super(cylinders, name);
    }

    public String startEngine() {
        // return " Holden -> startEngine()";
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String accelerate() {
        // return "Holden -> accelerate()";
        return getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        // return "Holden -> brake()";
        return getClass().getSimpleName() + " -> brake()";
    }
}
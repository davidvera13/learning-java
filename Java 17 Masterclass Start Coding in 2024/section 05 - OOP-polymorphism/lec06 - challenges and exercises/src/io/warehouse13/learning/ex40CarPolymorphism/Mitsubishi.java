package io.warehouse13.learning.ex40CarPolymorphism;

public class Mitsubishi extends Car {

    public Mitsubishi (int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        // return " Mitsubishi -> startEngine()";
        return "#" + getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        // return "Mitsubishi -> accelerate()";
        return "#" + getClass().getSimpleName() + " -> accelerate()";
    }

    public String brake() {
        // return "Mitsubishi -> brake()";
        return "#" + getClass().getSimpleName() + " -> brake()";
    }
}

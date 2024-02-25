package io.warehouse13.learning;


import io.warehouse13.learning.abstractions.impl.Line;

public class River extends Line {

    private String name;

    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " River";
    }
}

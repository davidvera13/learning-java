package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Mappable;

import java.util.Arrays;

public class Point implements Mappable {

    private double[] location = new double[2];

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    @Override
    public void render() {

        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}

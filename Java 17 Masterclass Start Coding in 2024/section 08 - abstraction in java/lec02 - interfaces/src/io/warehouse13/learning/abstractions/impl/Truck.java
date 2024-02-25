package io.warehouse13.learning.abstractions.impl;

import io.warehouse13.learning.abstractions.Trackable;

public class Truck implements Trackable {
    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded");
    }
}

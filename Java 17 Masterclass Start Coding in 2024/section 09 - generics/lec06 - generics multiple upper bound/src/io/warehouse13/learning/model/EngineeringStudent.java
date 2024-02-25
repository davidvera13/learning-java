package io.warehouse13.learning.model;

public class EngineeringStudent extends Student {

    private double percentComplete;

    public EngineeringStudent() {
        percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}

package io.warehouse13.learning.model;

public class EngineeringStudent extends Student{
    private double courseCompletionPercentage;

    public EngineeringStudent() {
        courseCompletionPercentage = random.nextDouble(0, 100.001);
    }

    public double getCourseCompletionPercentage() {
        return courseCompletionPercentage;
    }

    @Override
    public String toString() {
        // justify left (%-15s)
        return "%s %8.1f%%".formatted(super.toString(), courseCompletionPercentage);
    }
}

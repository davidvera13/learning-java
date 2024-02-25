package io.warehouse13.learning.model;

import java.util.Comparator;

public class EngineeringStudentComparator implements Comparator<EngineeringStudent> {
    @Override
    public int compare(EngineeringStudent o1, EngineeringStudent o2) {
        return (int) (o1.getPercentComplete() - o2.getPercentComplete());
    }
}

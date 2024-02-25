package io.warehouse13.learning.domain;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        // year started is private on Employee ... we should :
        // 1. provide a getter
        // 2. make property public
        //return o1.yearStarted - o2.yearStarted;
        return o1.getName().compareTo(o2.getName());
    }
}

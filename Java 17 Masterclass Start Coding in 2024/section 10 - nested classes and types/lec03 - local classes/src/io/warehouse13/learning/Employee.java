package io.warehouse13.learning;

import java.util.Comparator;

public class Employee {
    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }


    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
        private String sortType;

        public EmployeeComparator() {
            // call constructor with param
            this("name");
        }

        public EmployeeComparator(String sortType) {
            this.sortType = sortType;
        }



        @Override
        public int compare(Employee o1, Employee o2) {
            // we couldn't use yearStarted comparison when using a class
            if(sortType.equalsIgnoreCase("yearStarted"))
                return o1.yearStarted - o2.yearStarted;
            return o1.name.compareTo(o2.name);
        }
    }
}

package io.warehouse13.learning;

import io.warehouse13.learning.domain.Employee;
import io.warehouse13.learning.domain.EmployeeComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Walter", 2015),
                new Employee(10005, "John", 2021),
                new Employee(10022, "Fox", 1994),
                new Employee(13151, "Dana", 2006) ,
                new Employee(10050, "Monica", 2003)
        ));

        var comparator = new EmployeeComparator<>();
        employees.sort(comparator);
        for(Employee employee: employees)
            System.out.println(employee);
        System.out.println("*******************");

        employees.sort(new Employee.EmployeeComparator<>());
        for(Employee employee: employees)
            System.out.println(employee);
        System.out.println("*******************");

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for(Employee employee: employees)
            System.out.println(employee);

    }
}

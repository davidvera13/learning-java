package io.warehouse13.learning;

import io.warehouse13.learning.domain.Employee;
import io.warehouse13.learning.domain.EmployeeComparator;
import io.warehouse13.learning.domain.StoreEmployee;

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

        // using static nested class
        employees.sort(new Employee.EmployeeComparator<>());
        for(Employee employee: employees)
            System.out.println(employee);
        System.out.println("*******************");

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for(Employee employee: employees)
            System.out.println(employee);
        System.out.println("*******************");

        // using inner class
        System.out.println("Store members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
               new StoreEmployee(11003, "John", 1961, "Beat Shop"),
                new StoreEmployee(11013, "Paul", 1960, "Beat Shop"),
                new StoreEmployee(11001, "George", 1960, "Beat Shop"),
                new StoreEmployee(10101, "Ringo", 1960, "Beat Shop"),
                new StoreEmployee(10121, "Marty", 1975, "Beat Shop"),
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10516, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")));

        var innerComparator = new StoreEmployee().new EmployeeComparator<>();
        storeEmployees.sort(innerComparator);
        for(Employee storeEmployee: storeEmployees)
            System.out.println(storeEmployee);
        System.out.println("*******************");

    }
}

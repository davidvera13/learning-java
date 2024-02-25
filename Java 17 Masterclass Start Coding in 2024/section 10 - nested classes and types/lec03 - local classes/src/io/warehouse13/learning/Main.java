package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(10001, "Ralph", 2015),
                new Employee(10005, "Carole", 2021),
                new Employee(10022, "Jane", 2013),
                new Employee(13151, "Laura", 2020),
                new Employee(10050, "Jim", 2018) ));

        var comparator = new EmployeeComparator<>();
        employees.sort(comparator);
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println("*******************");

        // using static nested class
        employees.sort(new Employee.EmployeeComparator<>());
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println("*******************");

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for (Employee employee : employees)
            System.out.println(employee);
        System.out.println("*******************");

        // using inner class
        System.out.println("Store members");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(11003, "John", 1961, "Beat Shop"),
                new StoreEmployee(11013, "Paul", 1960, "Beat Shop"),
                new StoreEmployee(11001, "George", 1960, "Beat Shop"),
                new StoreEmployee(10101, "Ringo", 1960, "Beat Shop"),
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10516, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")));

        var innerComparator = new StoreEmployee().new EmployeeComparator<>();
        storeEmployees.sort(innerComparator);
        for (Employee storeEmployee : storeEmployees)
            System.out.println(storeEmployee);
        System.out.println("*******************");

        System.out.println("With pig latin names");
        addPigLatinName(storeEmployees);

    }

    // Pig Latin is a pseudo-language or argot where we use a formal technique altering English words. The basic rule
    // is to switch the first consonant or consonant cluster to the end of the term and then adding suffix “ay” to form
    // a new word. For instance, the word 'pig' would become igp+ay which becomes igpay.
    public static void addPigLatinName(List<? extends StoreEmployee> list) {

         String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee
                implements Comparable<DecoratedEmployee> {

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                // this.pigLatinName = pigLatinName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (var dEmployee : newList) {
            //System.out.println(dEmployee.originalInstance + " " + dEmployee.pigLatinName);
            // both are private properties : originalInstance & pigLatinName
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }
    }

}
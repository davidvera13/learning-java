package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(11003, "John", 2019, "Target"),
                new StoreEmployee(11013, "Paul", 2021, "Walmart"),
                new StoreEmployee(11001, "George", 2020, "Macys"),
                new StoreEmployee(10101, "Ringo", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")));

        // we have 3 comparators here ..
        var comp1 = new EmployeeComparator<StoreEmployee>();
        var comp2 = new Employee.EmployeeComparator<StoreEmployee>();
        var comp3 = new StoreEmployee().new StoreEmployeeComparator<>();

        // we can create local class ...
        class NameSort<T> implements Comparator<StoreEmployee> {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }
        var comp4 = new NameSort<StoreEmployee>();

        // Using anonymous class
        var comp5 = new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        // we can pass all comparators ...
        sortIt(storeEmployees, comp1);
        sortIt(storeEmployees, comp2);
        sortIt(storeEmployees, comp3);
        sortIt(storeEmployees, comp4);
        sortIt(storeEmployees, comp5);

        // we can use directly anonymous class
        sortIt(storeEmployees, new Comparator<StoreEmployee>() {
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        // the previous line can be converted to lambda
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // the previous line can be replaced with 'Comparator.comparing'
        sortIt(storeEmployees, Comparator.comparing(Employee::getName));

    }

    public static <T> void sortIt(
            List<T> list,
            Comparator<? super  T> comparator) {
        System.out.println("Sorting with comparator: " + comparator.toString());
        list.sort(comparator);
        for (var employee: list)
            System.out.println(employee);
    }
}

package io.warehouse13.learning.challenge02employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Minnie", "Mouse", "01/03/1992"),
                new Employee("Mickey", "Mouse", "13/05/1987"),
                new Employee("Duffy", "Duck", "13/05/1991"),
                new Employee("Daisy", "Duck", "27/08/1993"),
                new Employee("Goofy", "Dog", "27/07/2004")
        ));

        printOrderedList(employees, "name");
        System.out.println("*************");
        printOrderedList(employees, "any");
    }

    public static void printOrderedList(List<Employee> employees, String sortField) {
        int currentYear = LocalDate.now().getYear();
        class CurrentEmployee {
            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public CurrentEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked = currentYear - Integer.parseInt(containedEmployee.hireDate().split("/")[2]);
                fullName = String.join(" ", containedEmployee.firstName(), containedEmployee.lastName());
            }

            @Override
            public String toString() {
                return "%s has been employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<CurrentEmployee> list = new ArrayList<>();
        for (Employee employee: employees)
            list.add(new CurrentEmployee(employee));

        var comparator = new Comparator<CurrentEmployee>() {
            @Override
            public int compare(CurrentEmployee o1, CurrentEmployee o2) {
                if(sortField.equals("name"))
                    return o1.fullName.compareTo(o2.fullName);
                return o1.yearsWorked - o2.yearsWorked;
            }
        };

        list.sort(comparator);
        for (var employee: list)
            System.out.println(employee);
    }
}

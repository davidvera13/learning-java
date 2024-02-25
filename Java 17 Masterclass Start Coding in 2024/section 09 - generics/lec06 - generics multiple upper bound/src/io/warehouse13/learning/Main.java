package io.warehouse13.learning;

import io.warehouse13.learning.model.Employee;
import io.warehouse13.learning.model.EngineeringStudent;
import io.warehouse13.learning.model.Student;
import io.warehouse13.learning.util.QueryList;

import java.util.ArrayList;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new EngineeringStudent());
        printMoreLists(students);

        List<EngineeringStudent> engineeringStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            engineeringStudents.add(new EngineeringStudent());
        }
        printMoreLists(engineeringStudents);

        testList(new ArrayList<>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(engineeringStudents);
        var matches = queryList.getMatches(
                "Course", "Python");
        printMoreLists(matches);

        // using statuc method
        var students2021 =
                QueryList.getMatches(students, "YearStarted", "2021");
        printMoreLists(students2021);

        // not a valid type ...
        // Type parameter 'io.warehouse13.learning.model.Employee' is not within its bound;
        // should extend 'io.warehouse13.learning.model.Student'
        // QueryList<Employee> employeeList = new QueryList<>();
    }

    public static void printMoreLists(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }
}

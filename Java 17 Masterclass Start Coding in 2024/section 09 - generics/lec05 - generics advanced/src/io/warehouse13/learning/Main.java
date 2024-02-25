package io.warehouse13.learning;

import io.warehouse13.learning.model.EngineeringStudent;
import io.warehouse13.learning.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int count = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < count; i++)
            students.add(new Student());

        // we can add engineering student if we want
        students.add(new EngineeringStudent());

        printList(students);
        System.out.println("**********");
        List<EngineeringStudent> engineeringStudents = new ArrayList<>();
        for (int i = 0; i < count; i++)
            engineeringStudents.add(new EngineeringStudent());

        // this is not inheritance ! List<EngineeringStudent> is not inehitance from List<Student>
        printList(engineeringStudents);

        System.out.println("**********");
        printMoreList(students);
        System.out.println("**********");
        printMoreList(engineeringStudents);

        System.out.println("**********");
        testList(new ArrayList<>(List.of("Apple", "Banana", "Chocolate")));
        testList(new ArrayList<>(List.of(3, 14, 156)));
    }


    //public static void printList(List<Student> students) {
    //    for (var student: students)
    //        System.out.println(student);
    //    System.out.println();
    //}

    // here is a generic method and we can pass List<Student> or List<EngineeringStudent>
    // adding extends Student we can pass Student and sub classes
    public static <T extends Student> void printList(List<T> students) {
        for (var student: students)
            System.out.println(student.getYearStarted() + ": " + student);
        System.out.println();
    }


    // we're using here wildcard : ? type is unknow byt it extends Student ...
    // we can paxs any subclass of Student
    public static void printMoreList(List<? extends Student> students) {
        //Student last = students.get(students.size() - 1);
        //students.set(0, last);

        for (var student: students)
            System.out.println(student.getYearStarted() + ": " + student);
        System.out.println();
    }

    // those two methods will generate type erasure: on compile, those two methods
    // will require a list of objects
    //public static void testList(List<String> list) {
    //    for (var str: list)
    //        System.out.println("String: " + str.toUpperCase());
    //}

    //public static void testList(List<Integer> list) {
    //    for (var num: list)
    //        System.out.println("String: " + num.floatValue());
    //}

    // we can fix type erasure
    public static void testList(List<?> list) {
            for (var elt: list) {
                if (elt instanceof String str)
                    System.out.println("String: " + str.toUpperCase());
                if (elt instanceof Integer num)
                    System.out.println("String: " + num.floatValue());
            }
    }
}

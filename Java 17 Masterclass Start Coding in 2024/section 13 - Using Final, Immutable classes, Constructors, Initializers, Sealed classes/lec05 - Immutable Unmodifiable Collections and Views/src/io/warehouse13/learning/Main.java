package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Still struggling with generics and immutables");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students);
        // Unmodifiable
        List<Student> studentsSecondCopy = List.copyOf(students);
        List<Student> studentsThirdCopy = Collections.unmodifiableList(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
        studentsFirstCopy.sort(Comparator.comparing(Student::getName));
        // Exception in thread "main" java.lang.UnsupportedOperationException
        //  at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        // studentsSecondCopy.add(new Student("Bonnie", new StringBuilder()));
        // studentsSecondCopy.sort(Comparator.comparing(Student::getName));

        // Immutable object is modified
        //studentsThirdCopy.set(0, new Student("Bonnie", new StringBuilder()));

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Mastering Java !");


        bobsNotes.append("Need to learn more immutables and collections");

        students.forEach(System.out::println);
        System.out.println("*******************************");
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("*******************************");
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("*******************************");
        studentsThirdCopy.forEach(System.out::println);
        System.out.println("*******************************");
    }
}

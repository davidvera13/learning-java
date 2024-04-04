package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class");
        Course javaCourse = new Course("JMC", "Java Masterclass");

        Student[] students = new Student[1000];
        Arrays.setAll(students, (i) -> Student.getRandomStudent(javaCourse, pythonCourse));
        // CONVERTING TO A LIST ...
        System.out.println("Converting to list & array");
        System.out.println("*******************************");
        List<Student> studentList = Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList();

        studentList.stream().limit(5).forEach(System.out::println);
        var studentObjArr = Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray();

        // we can be more specific and we have here a student array
        var studentArr = Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray(Student[]::new);
                //.toArray(size -> new Student[size]);

        List<Student> studentListAlt = Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                // warning: 'collect(toList())' can be replaced with 'toList()' if we don't use Collections
                .collect(Collectors.toList());

        // no more warning....mutable list
        Collections.shuffle(studentListAlt);
        // Immutable object is passed where mutable is expected
        // Collections.shuffle(studentList);

    }
}

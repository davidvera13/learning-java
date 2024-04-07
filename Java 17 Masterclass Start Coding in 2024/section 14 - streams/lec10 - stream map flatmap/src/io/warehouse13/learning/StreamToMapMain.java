package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Collectors.html#method-summary

public class StreamToMapMain {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGMAE", "Create Java Games in Java");

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(javaCourse, pythonCourse))
                .toList();

        // create map with country code as key and students as value
        var mappedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));
        mappedStudents.forEach((k, v) -> System.out.println(k + " -> " + v.size()));

        System.out.println("***********************");
        int minAge = 25;
        // we omport static
        var youngerSet = students.stream()
                .collect(groupingBy(
                        Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge , toList())));
        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));


        System.out.println("***********************");
        // partitionning on boolean
        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced students: " + experienced.get(true).size());

        var experiencedCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced students: " + experiencedCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(partitioningBy(
                        s ->  s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                        counting()));
        System.out.println("Experienced and Active Students = " + experiencedAndActive.get(true));

        var multilevel = students.stream()
                .collect(groupingBy(
                        Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multilevel.forEach((key, value) -> {
            System.out.println(key);
            value.forEach((key1, value1) ->
                    System.out.println("\t" + key1 + " " + value1.size()));
        });
    }

}


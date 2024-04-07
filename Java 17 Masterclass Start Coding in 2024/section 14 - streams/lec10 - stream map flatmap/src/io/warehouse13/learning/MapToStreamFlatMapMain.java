package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class MapToStreamFlatMapMain {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(javaCourse, pythonCourse))
                .toList();

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced students: " + experienced.get(true).size());

        var multilevel = students.stream()
                .collect(groupingBy(
                        Student::getCountryCode,
                        groupingBy(Student::getGender)));

        //long studentCount = students.stream().count();
        long studentCount = students.size();
        System.out.println(studentCount);

        long studentBodyCount = 0;
        for (var list: experienced.values())
            studentBodyCount += list.size();
        System.out.println("studentBodyCount = "  + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                //.mapToInt(l -> l.size())
                .mapToInt(List::size)
                .sum();
        System.out.println("studentBodyCount = "  + studentBodyCount);

        // add filter ...
        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream().filter(s -> s.getMonthsSinceActive() <= 3).count())
                //.mapToInt(l -> l.size())
                .mapToLong(l -> l)
                .sum();
        System.out.println("studentBodyCount = "  + studentBodyCount);

        // using flat map
        long count = experienced.values().stream()
                //.flatMap(l -> l.stream())
                .flatMap(Collection::stream)
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students: " + count);

        // very ugly ...
        count = multilevel.values().stream()
                .flatMap(map -> map.values().stream()
                        .flatMap(Collection::stream))
                        //.flatMap(l -> l.stream()))
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students in multilevel: " + count);

        // prettier
        count = multilevel.values().stream()
                .flatMap(map -> map.values().stream())
                //.flatMap(l -> l.stream())
                .flatMap(Collection::stream)
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students in multilevel: " + count);
    }
}


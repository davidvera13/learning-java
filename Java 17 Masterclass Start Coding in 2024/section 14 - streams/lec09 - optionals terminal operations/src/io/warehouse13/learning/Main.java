package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);


        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(javaCourse, pythonCourse))
                .limit(1000)
                .toList();

        int minAge= 21;
        optionalStream(students, minAge);
        System.out.println("***********************");
        optionalStream(students, 18);
        System.out.println("***********************");

        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(
                        System.out::println, // if true
                        () -> System.out.println("Missing FR")); // else

        // singlestatement
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("FR"))
                .findAny()
                .ifPresentOrElse(
                        System.out::println, // if true
                        () -> System.out.println("Missing FR")); // else

    }

    private static void optionalStream(List<Student> students, int minAge) {
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findAny()
                .ifPresentOrElse(s ->
                                System.out.printf("Student %d from %s is %d%n",
                                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findFirst()
                .ifPresentOrElse(s ->
                                System.out.printf("Student %d from %s is %d%n",
                                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));


        // the 2 stream pipes are identical, sorting and finding first is equivalent to getting minimum
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .sorted(Comparator.comparing(Student::getAge))
                .findFirst()
                .ifPresentOrElse(s ->
                                System.out.printf("Student %d from %s is %d%n",
                                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        // better solution
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s ->
                                System.out.printf("Student %d from %s is %d%n",
                                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));


        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s ->
                                System.out.printf("Student %d from %s is %d%n",
                                        s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));


        // we extract age of students under 21 and calculate average age
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(a -> System.out.printf("Avg age under %d: %.2f%n", minAge, a),
                        () -> System.out.println("Didn't find anyone under " + minAge));


        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a, b) -> String.join(",", a, b))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("None found"));

    }

}


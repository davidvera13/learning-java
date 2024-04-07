package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);


        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(javaCourse, pythonCourse))
                .limit(1000)
                .collect(Collectors.toList());


        Optional<Student> optionalStudent1 = getStudent(null, "first");
        System.out.println("Empty : " + optionalStudent1.isEmpty() + " - Present: " + optionalStudent1.isPresent());
        System.out.println(optionalStudent1);
        System.out.println("***************************");


        Optional<Student> optionalStudent2 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty : " + optionalStudent2.isEmpty() + " - Present: " + optionalStudent2.isPresent());
        System.out.println(optionalStudent2);
        System.out.println("***************************");

        Optional<Student> optionalStudent3 = getStudent(students, "first");
        System.out.println("Empty : " + optionalStudent3.isEmpty() + " - Present: " + optionalStudent3.isPresent());
        System.out.println(optionalStudent3);
        //System.out.println(optionalStudent3.get());
        optionalStudent3.ifPresent(System.out::println);
        System.out.println("***************************");

        // will throw null pointer exception > requires Optional.ofNullable instead of Optional.of
        students.add(0, null);
        Optional<Student> optionalStudent4 = getStudent(students, "first");
        System.out.println("Empty : " + optionalStudent4.isEmpty() + " - Present: " + optionalStudent4.isPresent());
        System.out.println(optionalStudent4);

        // Student firstStudent = optionalStudent4.isPresent() ? optionalStudent4.get() : null;
        // Student firstStudent = optionalStudent4.orElse(null);
        // long firstStudentId =   (firstStudent == null) ? - 1: firstStudent.getStudentId();
        // System.out.println(optionalStudent4.get()); // no such element exception
        optionalStudent4.ifPresent(System.out::println);
        //Student firstStudent = optionalStudent4.orElse(getDummyStudent(javaCourse, pythonCourse));
        Student firstStudent = optionalStudent4.orElseGet(() -> getDummyStudent(javaCourse, pythonCourse));
        long firstStudentId =   firstStudent.getStudentId();
        System.out.println("First student Id : " + firstStudentId);
        System.out.println("***************************");


        students.remove(0);
        // this is not a stream pipeline !
        // start
        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Missing FR"));
        // end
    }

    private static Optional<Student> getStudent(List<Student> list, String type) {
        if(list == null || list.isEmpty())
            return Optional.empty();
        else if(type.equals("first"))
            //return Optional.of(list.get(0));
            return Optional.ofNullable(list.get(0));
        else if(type.equals("last"))
            //return Optional.of(list.get(list.size() - 1));
            return Optional.ofNullable(list.get(list.size() - 1));

        //return Optional.of(list.get(new Random().nextInt(0, list.size() - 1)));
        return Optional.ofNullable(list.get(new Random().nextInt(0, list.size() - 1)));
    }

    private static Student getDummyStudent(Course... courses) {
        System.out.println("--> Getting the dummy student");
        return new Student("NO", 1, 1, "U",
                false, courses);
    }

}


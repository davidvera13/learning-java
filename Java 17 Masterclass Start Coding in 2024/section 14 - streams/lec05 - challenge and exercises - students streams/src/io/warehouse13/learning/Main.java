package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course pythonCourse = new Course("PYMC", "Python Master class");
        Course javaCourse = new Course("JMC", "Java Masterclass");

        Student john =
                new Student(
                        "UK",
                        2019,
                        30,
                        "M",
                        true,
                        pythonCourse, javaCourse);

        System.out.println(john);
        john.wathLecture("JMC", 10, 5, 2019);
        john.wathLecture("PYMC", 7, 7, 2020);
        System.out.println(john);

        // generate 10 random students
        Stream.generate(() -> Student.getRandomStudent(javaCourse, pythonCourse))
                .limit(10)
                .forEach(System.out::println);

        System.out.println("******************************");
        // generate 1000 students and count how many males and females are enrolled
        Student[] students = new Student[1000];
        Arrays.setAll(students, (i) -> Student.getRandomStudent(javaCourse, pythonCourse));
        //var maleStudents = Stream.generate(
        //        () -> Student.getRandomStudent(javaCourse, pythonCourse))
        //        .limit(1000);
        var maleStudents = Arrays.stream(students)
                .filter(student -> student.getGender().equals("M"))
                .count();


        //var femaleStudents = Arrays.stream(students)
        //        .filter(student -> student.getGender().equals("M"))
        //        .count();

        //var unknown = Arrays.stream(students)
        //       .filter(student -> student.getGender().equals("U"))
        //       .count();
        System.out.println("Males: " + maleStudents);
        //System.out.println("Females: " + femaleStudents);
        //System.out.println("unknown: " + unknown);
        //System.out.println("Total : " + (maleStudents + femaleStudents + unknown));

        for(String gender: List.of("M", "F", "U")) {
            var s = Arrays.stream(students)
                    .filter(student -> student.getGender().equals(gender));
            System.out.println("# of " + gender + " students " + s.count());
        }
        // filter by ages
        System.out.println("******************************");
        List<Predicate<Student>> predicatesList = List.of(
                (s) -> s.getAge() < 30,
                (Student s) -> s.getAge() >= 30 && s.getAge() < 60);


        long total = 0;
        for (int i = 0; i < predicatesList.size(); i++) {
            var s = Arrays.stream(students).filter(predicatesList.get(i));
            long count = s.count();
            total += count;
            System.out.printf("# of students (%s) = %d%n",
                    i == 0 ? " < 30" : ">= 30 & < 60", count);
        }
        System.out.println("# of students >= 60 = " + (students.length - total));

        // summary stats
        System.out.println("******************************");
        var ageStream = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);
        System.out.println("Stats for enrollment age: " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAge);
        System.out.println("Stats for enrollment age: " + currentAgeStream.summaryStatistics());

        // by country code
        System.out.println("******************************");
        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        // active students which registered 7 years ago at least
        System.out.println();
        System.out.println("******************************");
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                        s.getMonthsSinceActive() < 12);
        System.out.println("Long term students ? " + longTerm);

        long longTermCount = Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .count();
        System.out.println("Long term students: " + longTermCount);

        // print the long term student without programming experience (5 entries only)
        Arrays.stream(students)
                .filter(s ->
                        s.getAge() - s.getAgeEnrolled() >= 7 &&
                                s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .forEach(System.out::println);


    }
}

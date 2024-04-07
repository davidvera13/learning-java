package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.CourseEngagement;
import io.warehouse13.learning.domain.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    // In this challenge, you'll again use streams with the Student Engagement Code.
    // Before you start, first change the getRandomStudent method on Student, to select a random number and random
    // selection of courses.
    // Every student should be enrolled, and have activity in at least one class.
    // Set up three or four courses, use the lecture count version of the constructor on several of these, to pass
    // lecture counts greater than 40.
    // Generate a list of 10,000 students, who've enrolled in the past 4 years.
    // Pass the supplier code three or four courses.
    // Next, answer the following questions.
    // How many of the students are enrolled in each class?
    // How many students are taking 1, 2, or 3 classes?
    // Determine the average percentage complete, for all courses, for this group of students.  Hint, try Collectors.
    // averagingDouble to get this information.
    // For each course, get activity counts by year, using the last activity year field.
    // Think about how you'd go about answering these questions, using some of the stream operations you've learned,
    // especially the collect terminal operation in conjunction, with the Collectors helper class methods.
    public static void main(String[] args) {
        int currentYear = LocalDate.now().getYear();
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Create Java Games in Java");
        Course angular = new Course("ANG", "Create SPA with Angular", 98);

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(pythonCourse, javaCourse, jgames, angular))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

        System.out.println(students.stream().mapToInt(Student::getYearEnrolled).summaryStatistics());

        // sample print
        System.out.println("***************************");
        students.subList(0, 10).forEach(System.out::println);
        System.out.println("***************************");

        // min number of course per student, average courses for a student, max number of courses per student
        System.out.println(students.stream()
                .mapToInt(s -> s.getEngagements().size()).summaryStatistics());


        // How many of the students are enrolled in each class?
        var mappedActivity = students.stream()
                .flatMap(s -> s.getEngagements().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.counting()));
        System.out.println("How many of the students are enrolled in each class?");
        mappedActivity.forEach((k, v) -> System.out.println(k + " -> " + v) );


        // How many students are taking 1, 2, or 3 classes?
        var classCounts = students.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getEngagements().size(),
                        Collectors.counting()));
        System.out.println("How many students are enrolled in 1, 2 or 3 courses");
        classCounts.forEach((k, v) -> System.out.println(k + " -> " + v) );

        // Determine the average percentage complete, for all courses, for this group of students.  Hint, try Collectors.
        // averagingDouble to get this information.
        var percentages = students.stream()
                .flatMap(s -> s.getEngagements().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.averagingDouble(CourseEngagement::getPercentComplete)));
        System.out.println("Determine the average percentage complete, for all courses, for this group of students");
        percentages.forEach((k, v) -> System.out.println(k + " -> " + v) );

        var summarizing = students.stream()
                .flatMap(s -> s.getEngagements().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.summarizingDouble(CourseEngagement::getPercentComplete)));
        System.out.println("Summarizing");
        summarizing.forEach((k, v) -> System.out.println(k + " -> " + v) );

        // For each course, get activity counts by year, using the last activity year field.

        var yearMap = students.stream()
                .flatMap(s -> s.getEngagements().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getCourseCode,
                        Collectors.groupingBy(
                                CourseEngagement::getLastActivityYear,
                                Collectors.counting()
                        )));
        System.out.println("Summarizing");
        yearMap.forEach((k, v) -> System.out.println(k + " -> " + v) );

        students.stream()
                .flatMap(student -> student.getEngagements().values().stream())
                .collect(Collectors.groupingBy(
                        CourseEngagement::getEnrollmentYear,
                        Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.counting())))
                .forEach((k, v) -> System.out.println(k + " -> " + v));

    }
}

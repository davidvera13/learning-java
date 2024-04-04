package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Copy the two courses, jmc and pymc, from the MainCollect's main method, passing both an additional argument
        // for the lecture count, so 50 for pymc, and 100 for jmc.
        // Add a third course, titled "Creating Games in Java".   You don't have to pass a lecture count for this one.
        Course pythonCourse = new Course("PYMC", "Python Master class", 50);
        Course javaCourse = new Course("JMC", "Java Masterclass", 100);
        Course javeGameCourse = new Course("JGAME", "Creating games in Java");

        // Use Stream.generate or Stream.iterate to generate 5000 random students, and create a list of these.
        //List<Student> students = Stream.generate(() ->
        //                Student.getRandomStudent(javaCourse, pythonCourse, javeGameCourse))
        //        .limit(5000)
        //        .toList();

        //List<Student> students = Stream.iterate(1, s -> s < 5000, s -> s + 1)
        //        .limit(10)
        //        //.peek(System.out::println)
        //        .map(s -> Student.getRandomStudent(javaCourse, pythonCourse))
        //        .peek(System.out::println)
        //        .toList();

        List<Student> students = IntStream.rangeClosed(1, 5000)
                //.limit(10)
                //.peek(System.out::println)
                .mapToObj(s -> Student.getRandomStudent(javaCourse, pythonCourse))
                //.peek(System.out::println)
                .toList();

        // Use your getPercentComplete method, to calculate the average percentage completed for all students for just the Java Masterclass, using the reduce terminal operation
        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete(javaCourse.courseCode()))
                .reduce(0, Double::sum);
        double avgPercent = totalPercent / students.size();
        System.out.printf("Average percentage complete : %.2f%% %n", avgPercent);

        // Use this result, multiplying it by 1.25, to collect a group of students (either as a list, or a set).  These
        // would be the students who've completed more than three quarters of that average percentage.
        int topPercent = (int) (1.25 * avgPercent);
        System.out.printf("Best percentage complete : %d%% %n", topPercent);

        List<Student> hardWorkers = students.stream()
                .filter(student -> student.getMonthsSinceActive(javaCourse.courseCode()) == 0)
                .filter(student -> student.getPercentComplete(javaCourse.courseCode()) >= topPercent)
                .toList();

        System.out.println("# hardworkers ? = " + hardWorkers.size());
        System.out.println("************************");
        // Sort by the longest enrolled students who are still active, because you're going to offer your new course to 10 of these students, for a trial run.
        // Add the new course to these ten students.
        // Make one change to the Student's getRandomStudent method, using a minimum lecture of 30.
        Comparator<Student> longTermsStudent = Comparator.comparing(Student::getYearEnrolled);
        List<Student> top10 = students.stream()
                .filter(student -> student.getMonthsSinceActive(javaCourse.courseCode()) == 0)
                .filter(student -> student.getPercentComplete(javaCourse.courseCode()) >= topPercent)
                .sorted(longTermsStudent)
                .limit(10)
                .toList();

        //System.out.println("# hardworkers ? = " + hardWorkers.size());
        top10.forEach(System.out::println);
        System.out.println("************************");
        top10.forEach(student -> {
            student.addCourse(javeGameCourse);
            System.out.println(student);
        });

        System.out.println("**************************************");
        top10.forEach(student -> System.out.print(student.getStudentId() + " "));
        System.out.println();


        Comparator<Student> uniqueSorted = longTermsStudent
                .thenComparing(Comparator.comparing(Student::getStudentId));
        students.stream()
                .filter(student -> student.getMonthsSinceActive(javaCourse.courseCode()) == 0)
                .filter(student -> student.getPercentComplete(javaCourse.courseCode()) >= topPercent)
                .sorted(longTermsStudent)
                .limit(10)
                //.toList()
                //.collect(Collectors.toList())
                //.collect(Collectors.toSet())
                // with longTermsStudent returns 1 value only
                .collect(() -> new TreeSet<>(uniqueSorted), TreeSet::add, TreeSet::addAll)
                .forEach(student -> {
                    student.addCourse(javeGameCourse);
                    System.out.print(student.getStudentId() + " ");
                });




    }
}


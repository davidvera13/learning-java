package io.warehouse13.learning;

import io.warehouse13.learning.domain.Course;
import io.warehouse13.learning.domain.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        // collect and reduce
        Course pythonCourse = new Course("PYMC", "Python Master class");
        Course javaCourse = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(pythonCourse, javaCourse))
                .limit(1000)
                .toList();

        // collect from previous list
        Set<Student> frenchies = students.stream()
                .filter(student -> student.getCountryCode().equals("FR"))
                .collect(Collectors.toSet());
        System.out.println("# French students : " + frenchies.size());

        Set<Student> under30 = students.stream()
                .filter(student -> student.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("# students < 30 : " + under30.size());

        Set<Student> youngFrenchies1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        // intersect
        youngFrenchies1.addAll(frenchies);
        youngFrenchies1.retainAll(under30);

        // student must implement comparable
        Set<Student> youngFrenchies2 = students.stream()
                .filter(student -> student.getAgeEnrolled() < 30)
                .filter(student -> student.getCountryCode().equals("FR"))
                //.collect(Collectors.toSet());
                // Exception in thread "main" java.lang.ClassCastException: class io.warehouse13.learning.domain.Student cannot be cast to class java.lang.Comparable (io.warehouse13.learning.domain.Student is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
                //.collect(TreeSet:: new, TreeSet::add, TreeSet::addAll);
                .collect(() ->
                        new TreeSet<>(Comparator.comparing(Student::getStudentId)),
                        TreeSet::add, TreeSet::addAll);

        youngFrenchies1.forEach(student -> System.out.print(student.getStudentId() + " "));
        System.out.println();
        youngFrenchies2.forEach(student -> System.out.print(student.getStudentId() + " "));
        System.out.println();

        // reduce, we're not cumulating
        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList: " + countryList);

    }
}

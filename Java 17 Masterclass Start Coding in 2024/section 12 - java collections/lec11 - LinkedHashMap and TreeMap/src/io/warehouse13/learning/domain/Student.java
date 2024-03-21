package io.warehouse13.learning.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Student {
    public static int lastId = 1;
    private String name;
    private int id;
    private final List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
        id = lastId++;
    }

    public Student(String name, Course course) {
        this(name, new ArrayList<>(List.of(course)));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        String[] courseNames = new String[courses.size()];
        Arrays.setAll(courseNames, i -> courses.get(i).name());

        return "[%d] : %s".formatted(id, String.join(", ", courseNames));
    }
}

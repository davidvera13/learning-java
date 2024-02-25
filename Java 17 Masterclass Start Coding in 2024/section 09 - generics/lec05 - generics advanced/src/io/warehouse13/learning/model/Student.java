package io.warehouse13.learning.model;

import java.util.Random;

public class Student {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();
    private static String[] names = { "John", "Paul", "Georges", "Ringo", "Billy"};
    private static String[] courses = { "C++", "Java", "Python"};

    public Student() {
        // A to Z
        int nameIndex = random.nextInt(65, 91);
        name = names[random.nextInt(5)] + " " + (char) nameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2024);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString() {
        // justify left (%-15s)
        return "%-15s \t%-15s \t%d".formatted(name, course, yearStarted);
    }
}

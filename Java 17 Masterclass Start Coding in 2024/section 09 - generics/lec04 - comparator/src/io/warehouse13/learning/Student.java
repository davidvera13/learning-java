package io.warehouse13.learning;

import java.util.Random;

public class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    // we can use protected if we have sub type
    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }


    @Override
    public int compareTo(Student student) {
        //return Integer.valueOf(this.id).compareTo(Integer.valueOf(student.id));
        return Integer.compare(this.id, student.id);
    }

    //@Override
    //public int compareTo(Object o) {
    //    return this.name.compareTo(((Student) o).name);
    //}
}

package io.warehouse13.learning;

public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }

    //@Override
    //public int compareTo(Object o) {
    //    return this.name.compareTo(((Student) o).name);
    //}
}

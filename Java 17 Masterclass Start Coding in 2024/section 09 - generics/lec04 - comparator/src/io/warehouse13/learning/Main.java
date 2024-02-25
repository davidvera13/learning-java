package io.warehouse13.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = { 0, 5, 10, -50, 50};
        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d\t: compare to = %d%n", five, (val == 0 ? "==" : (val < 0) ? "<" : ">"), i , val);
        }

        System.out.println("************");
        String banana = "banana";
        String[] fruits= {"apple", "banana", "pear", "BANANA"};
        for (String fruit : fruits) {
            int val = banana.compareTo(fruit);
            System.out.printf("%s %s %s\t: compare to = %d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), fruit , val);
        }

        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        // check letters
        System.out.println("A: " + (int) 'A' + " \t" + "a: " + (int) 'a');
        System.out.println("B: " + (int) 'B' + " \t" + "b: " + (int) 'b');
        System.out.println("P: " + (int) 'P' + " \t" + "p: " + (int) 'p');

        // with object
        Student tom = new Student("Tom");
        Student zoe = new Student("Zoe");
        Student ann = new Student("Ann");
        List<Student> studentList = List.of(tom, zoe, ann);
        Student[] students = { new Student("Zoe"), new Student("Ann"), new Student("Tom") };
        // Student cannot be cast to class java.lang.Comparable because comparable is not implemented
        Arrays.sort(students);
        System.out.println(studentList);
        System.out.println(Arrays.toString(students));
        System.out.println("************");
        System.out.println(tom.compareTo(new Student("TOm")));

        // if we don't parametrize comparable we could compare string to int, object to string ...
        // tom.compareTo("What ? cast exception ?");
        Comparator<Student> gpaSorter = new StudentGpaComparator();
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

    }
}

package io.warehouse13.learning.ex31Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        // firstName is set to empty string
        person.setFirstName("");
        // lastName is set to empty string
        person.setLastName("");
        person.setAge(10);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        // firstName is set to John
        person.setFirstName("John");
        person.setAge(18);
        System.out.println("fullName= " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        // lastName is set to Smith
        person.setLastName("Smith");
        System.out.println("fullName= " + person.getFullName());

    }
}

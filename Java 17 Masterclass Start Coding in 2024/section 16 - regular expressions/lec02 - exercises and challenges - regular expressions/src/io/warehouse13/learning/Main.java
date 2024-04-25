package io.warehouse13.learning;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String phrase = "Hello, World!";
        boolean matches = phrase.matches("Hello, World!");
        System.out.println(matches);

        List<String> sentences;

        sentences = List.of(
                "The bike is red.",
                "I am a new Student.",
                "Hello ! how are you ?",
                "hello world.");

        // should start by an uppercase followed by any characters and should end with a dot;
        // String pattern = "[A-z].*\\.";
        String pattern;

        pattern = "[A-z][a-z\\s]+[.]";
        for(String sentence: sentences) {
            System.out.println(sentence.matches(pattern)  + " : " + sentence);
        }

        System.out.println("******************");

        sentences = List.of(
                "The bike is red, and has flat tires.",
                "I am a new Java O.O.P Student!",
                "Hello, friends and family: Welcome!",
                "How are you John Wick ?");

        //pattern = "[A-z].+[.?!]";
        pattern = "^[A-z][\\p{all}]+[.?!]$";
        for(String sentence: sentences) {
            System.out.println(sentence.matches(pattern)  + " : " + sentence);
        }


    }
}

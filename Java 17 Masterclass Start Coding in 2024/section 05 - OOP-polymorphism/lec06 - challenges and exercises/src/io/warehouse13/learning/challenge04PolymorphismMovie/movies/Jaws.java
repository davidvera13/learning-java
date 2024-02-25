package io.warehouse13.learning.challenge04PolymorphismMovie.movies;

public class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark eats a lot of people";
    }
}

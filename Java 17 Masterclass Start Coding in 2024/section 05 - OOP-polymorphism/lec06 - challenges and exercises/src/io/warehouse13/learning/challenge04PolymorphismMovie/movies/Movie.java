package io.warehouse13.learning.challenge04PolymorphismMovie.movies;

public class Movie {
    private final String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

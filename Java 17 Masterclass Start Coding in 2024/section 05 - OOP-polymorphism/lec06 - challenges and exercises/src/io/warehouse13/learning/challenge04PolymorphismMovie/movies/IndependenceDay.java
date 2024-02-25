package io.warehouse13.learning.challenge04PolymorphismMovie.movies;

public class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        // return super.plot();
        return "Aliens attempt to take over planet earth";
    }
}

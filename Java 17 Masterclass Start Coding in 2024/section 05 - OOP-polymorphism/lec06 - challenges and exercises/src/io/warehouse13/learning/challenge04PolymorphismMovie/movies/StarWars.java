package io.warehouse13.learning.challenge04PolymorphismMovie.movies;

public class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        // return super.plot();
        return "Imperial forces try to take over the universe";
    }
}

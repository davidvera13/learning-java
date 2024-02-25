package io.warehouse13.learning.challenge04PolymorphismMovie;


import io.warehouse13.learning.challenge04PolymorphismMovie.movies.*;

public class MovieApp {

    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + ": " + movie.getName());
            System.out.println("plot: " + movie.plot());
            System.out.println("********************");
        }
    }

    public static Movie randomMovie() {
        int rand = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was " + rand);

        return switch (rand) {
            case 1 -> new Jaws();
            case 2 -> new IndependenceDay();
            case 3 -> new MazeRunner();
            case 4 -> new StarWars();
            case 5 -> new ForgettableMovie();
            default -> null;
        };
    }
}

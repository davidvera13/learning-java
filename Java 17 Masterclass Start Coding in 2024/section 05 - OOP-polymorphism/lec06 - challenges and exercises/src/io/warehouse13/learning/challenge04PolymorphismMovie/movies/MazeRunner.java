package io.warehouse13.learning.challenge04PolymorphismMovie.movies;

public class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        // return super.plot();
        return "Kids try and escape a Maze";
    }
}

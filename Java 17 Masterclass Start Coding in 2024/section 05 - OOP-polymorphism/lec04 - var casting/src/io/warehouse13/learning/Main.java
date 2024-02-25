package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();
        System.out.println("******************");

        // using casting
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();
        System.out.println("******************");

        // java.lang.ClassCastException
        // Adventure jaws2 = (Adventure) Movie.getMovie("C", "Jaws");
        // jaws.watchMovie();
        // System.out.println("******************");

        // using casting
        Object comedy = Movie.getMovie("C", "Airplance");
        ((Comedy) comedy).watchMovie();
        // only available for comedy
        ((Comedy) comedy).watchComedyMovie();


        // using var: local variable type inference
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedyMovie();
        plane.watchMovie();
    }
}

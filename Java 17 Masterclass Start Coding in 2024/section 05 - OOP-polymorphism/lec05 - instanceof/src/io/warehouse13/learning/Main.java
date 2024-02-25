package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        Object unknown = Movie.getMovie("C", "Airplane");
        // we can use getSimpleName to get class name
        System.out.println("unknown.getClass().getSimpleName() >> " + unknown.getClass().getSimpleName());
        checkInstance(unknown);
        System.out.println("***********************");
        checkInstanceAlt(unknown);
    }

    private static void checkInstance(Object unknown) {
        if(unknown instanceof Adventure) {
            System.out.println("Adventure");
            ((Adventure) unknown).watchAdventureMovie();
        } else if (unknown instanceof Comedy) {
            System.out.println("Comedy");
            ((Comedy) unknown).watchComedyMovie();
            ((Comedy) unknown).watchMovie();
        } else if (unknown instanceof ScienceFiction) {
            System.out.println("SciFi");
            ((ScienceFiction) unknown).watchScienceFictionMovie();
        } else {
            System.out.println("Something went wrong");
        }
    }

    private static void checkInstanceAlt(Object unknown) {
        if(unknown instanceof Adventure adventure) {
            System.out.println("Adventure");
            adventure.watchAdventureMovie();
        } else if (unknown instanceof Comedy comedy) {
            System.out.println("Comedy");
            comedy.watchComedyMovie();
            comedy.watchMovie();
        } else if (unknown instanceof ScienceFiction scienceFiction) {
            System.out.println("SciFi");
            scienceFiction.watchScienceFictionMovie();
        } else {
            System.out.println("Something went wrong");
        }
    }
}

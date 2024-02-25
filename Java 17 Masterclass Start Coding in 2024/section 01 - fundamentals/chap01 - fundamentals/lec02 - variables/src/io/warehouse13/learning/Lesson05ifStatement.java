package io.warehouse13.learning;

public class Lesson05ifStatement {
    public static void main(String[] args) {
        boolean isAlien = false;
        //noinspection ConstantConditions
        // two eguals is comparison
        if(isAlien == false)
            System.out.println("He's from this earth");
        else
            System.out.println("Not from this earth");

        if(isAlien == false)
            System.out.println("He's from this earth");
        System.out.println("Im afraid no ghost");


        // common beginner error: assignement instead or equality checking
        boolean isCar = false;
        if(isCar = true) {
            System.out.println("Oops something went wrong");
        }

        // shortcut
        isCar = false;
        if(!isCar) {
            System.out.println("It's not a car");
        }
    }
}

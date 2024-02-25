package io.warehouse13.learning;

public class Lesson06logicalOperators {
    public static void main(String[] args) {
        int topScore = 100;
        if(topScore != 100)
            System.out.println("High score !!!");
        // ==, !=, >=, <=
        if(topScore >= 100)
            System.out.println("High score is greater or equal to 100 !!!");

        // and operator: both condition must be true
        topScore = 80;
        int secondScore = 60;
        if(topScore > secondScore && topScore < 100)
            System.out.println("Greater than second top score but less than 100");

        // make code easier to read with ()
        secondScore = 81;
        if((topScore > secondScore) && (topScore < 100))
            System.out.println("Greater than second top score but less than 100");

        // or operator: one condition must be true
        secondScore = 94;
        topScore = 95;
        if((topScore > 90) || (secondScore <= 90))
            System.out.println("Either or bother conditions are true...");


    }
}

package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        boolean isGameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        // blocks code
        if(score < 5000 && score < 1000) {
            System.out.println("Your score was less than 5000 but greater than 1000");
        } else if (score < 1000) {
            System.out.println("Your score was less than 1000");
        } else {
            System.out.println("Got here");
        }

        if(isGameOver) {
            // variable scope: finalScore is only avaiblable in this code block
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score is : " + finalScore);
        }
    }
}

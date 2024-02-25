package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        int newScore = calculateScore("John", 500);
        System.out.println("Final score is " + newScore);

        newScore = calculateScore(545);
        System.out.println("Final score is " + newScore);

        newScore = calculateScore();
        System.out.println("Final score is " + newScore);
    }



    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }
    public static int calculateScore(int score) {
        System.out.println("Unnamed Player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }
}

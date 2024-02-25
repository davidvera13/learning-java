package io.warehouse13.learning;

public class Main {
    public static void main(String[] args) {
        // boolean isGameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        calculateScore(true, score, levelCompleted, bonus);

        calculateScore(true, 800, 5, 100);
        calculateScore(true, 10000, 8, 200);

        System.out.println("Your final score is : " + score(true, 100000, 8, 200));

        // create a method called displayHighScorePosition
        // it should take a player name as parameter, and a second parameter as a position on the high score table
        // we should display the player name along with the message like "managed tp get into position
        // and the position they got and a further message " on the high score table"/

        // create a second method called calculateHighScorePosition
        // it should be sent one argument only, the player score
        // it should return an int
        // the return data should be:
        // 1 if the score > 1000
        // 2 if the score > 500 and score <= 1000
        // 3 if the score is > 100 and <= 500
        // 4 in all other cases
        // call both methods and display the results of the following scores:
        // 1500, 900, 400, 50
        System.out.println("**********************");
        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("John", highScorePosition);

        highScorePosition = calculateHighScorePosition(900);
        displayHighScorePosition("Paul", highScorePosition);

        highScorePosition = calculateHighScorePosition(400);
        displayHighScorePosition("Ringo", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Georges", highScorePosition);
    }

    private static void displayHighScorePosition(
            String playerName,
            int highScorePosition) {
        System.out.println(playerName + " managed to get into position "
                + highScorePosition + " on the high score table");
    }
    private static int calculateHighScorePosition(
            int playerScore) {
        if(playerScore > 1000)
            return 1;
        else if(playerScore > 500)
            return 2;
        else if(playerScore > 100)
            return 3;
        else
            return 4;
    }

    private static void calculateScore(
            boolean isGameOver,
            int score,
            int levelCompleted,
            int bonus) {
        if(isGameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score is : " + finalScore);
        }
    }

    private static int score(
            boolean isGameOver,
            int score,
            int levelCompleted,
            int bonus) {
        if (isGameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            return finalScore;
        }
        return -1;
    }
}

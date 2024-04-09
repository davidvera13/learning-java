package io.warehouse13.learning.game;

import java.util.Scanner;

public class GameConsole <T extends  Game<? extends Player>> {
    private final T game;
    private static final Scanner scanner = new Scanner(System.in);

    public GameConsole(T game) {
        this.game = game;
    }

    // for yahtzee
    public static String getUserInput(String prompt) {
        System.out.print(prompt + ":  ");
        return scanner.nextLine();
    }

    public int addPlayer() {
        System.out.println("Enter your player name: ");
        String name = scanner.nextLine();
        System.out.printf("Welcome to %s, %s!%n"
                .formatted(game.getGameName(), name));
        return game.addPlayer(name);
    }

    public void playGame(int playerIndex) {
        boolean done = false;
        while (!done) {
            var gameActions = game.getGameActions(playerIndex);
            System.out.println("Select one of the following actions:");
            for (Character c : gameActions.keySet()) {
                String prompt = gameActions.get(c).prompt();
                System.out.println("\t" + prompt + "(" + c + ")");
            }
            System.out.println("Enter next action: ");
            char nextMove = scanner.nextLine().toUpperCase().charAt(0);
            GameAction gameAction = gameActions.get(nextMove);
            if (gameAction != null) {
                System.out.println("************************");
                done = game.executeGameAction(playerIndex, gameAction);
                if (!done) {
                    System.out.println("************************");
                    // game over ?
                }
            }
        }
    }
}
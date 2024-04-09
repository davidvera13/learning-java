package io.warehouse13.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // In this challenge, we to start working on a dice rolling game, similar to an existing boxed game called
        // Yahtzee. The objective of the game is to roll five dice, to get certain combinations of numbers, each scored
        // differently. The player gets multiple tries to roll the dice, but after the first roll, players can select
        // which dice they want to roll again.
        // In this challenge, use the ints method on Random, to generate a finite stream, to create a list of 5 random
        // Integers, all between 1 and 6.
        // These will be the dice for your first roll.
        // Use the Scanner with System.in to have the user enter one of the following entries:
        // > The player should press Enter to keep all the dice.  This will end the play in this first part of the
        //   challenge.
        // > The player should enter ALL, to re throw all five dice.
        // > The player should enter numbers, representing dice face values, for those dice to be rolled again.
        //
        // Continue to loop, and throw the dice selected by the user, until the user presses enter.

        List<Integer> currentDice = new ArrayList<>();

        do {
            rollDice(currentDice);
        } while (!pickLosers(currentDice));
        System.out.println("Game over.  Real game would score and continue.");
    }

    private static void rollDice(List<Integer> currentDice) {

        int randomCount = 5 - currentDice.size();

        var newDice = random
                .ints(randomCount, 1, 7)
                .sorted()
                .boxed()
                .toList();

        currentDice.addAll(newDice);
        System.out.println("You're dice are: " + currentDice);

    }

    private static boolean pickLosers(List<Integer> currentDice) {
        String prompt = """
                    Press Enter to Score.
                    Type "ALL" to re-roll all the dice.
                    List numbers (separated by spaces) to re-roll selected dice.
                        """;

        System.out.print(prompt + "-->  ");
        String userInput = scanner.nextLine();
        if (userInput.isBlank()) {
            return true;
        }
        try {
            removeDice(currentDice, userInput.split(" "));

        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("Bad input, Try again");
        }
        return false;
    }

    private static void removeDice(List<Integer> currentDice, String[] selected) {
        if (selected.length == 1 && selected[0].contains("ALL")) {
            currentDice.clear();
        } else {
            for (String removed : selected) {
                currentDice.remove(Integer.valueOf(removed));
            }
            System.out.println("Keeping " + currentDice);
        }
    }
}

package io.warehouse13.learning;

import io.warehouse13.learning.game.GameConsole;
import io.warehouse13.learning.game.yahtzee.ScoredItem;
import io.warehouse13.learning.game.yahtzee.YahtzeeGame;
import io.warehouse13.learning.game.yahtzee.YahtzeePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class YahtzeeConsoleGame {
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

        //List<Integer> currentDice = new ArrayList<>(
        //        List.of(2, 2, 4, 4, 4)
        //);
        //for(ScoredItem item: ScoredItem.values()) {
        //    System.out.printf("Score for %s is %d %n", item, item.score(currentDice));
        //}

        var console = new GameConsole<>(
                new YahtzeeGame("Yahtzee"));

        console.playGame(console.addPlayer());
    }
}

package io.warehouse13.learning;

import io.warehouse13.learning.game.GameConsole;
import io.warehouse13.learning.game.shooter.ShooterGame;

public class ShooterConsoleGame {
    public static void main(String[] args) {
        var console = new GameConsole<>(new ShooterGame("Duck Hunt"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}

package io.warehouse13.learning;

import io.warehouse13.learning.game.GameConsole;
import io.warehouse13.learning.game.Weapon;
import io.warehouse13.learning.game.pirates.Pirate;
import io.warehouse13.learning.game.pirates.PirateGame;
import io.warehouse13.learning.game.shooter.ShooterGame;

import java.util.Objects;

public class PirateConsoleGame {
    public static void main(String[] args) {
        Weapon weapon = Weapon.getWeaponByChar('G');
        printWeapon(weapon);

        System.out.println("****************");
        var list = Weapon.getWeaponsByLevel(4);
        list.forEach(PirateConsoleGame::printWeapon);

        Pirate jackSparrow = new Pirate("Jack Sparrow");
        System.out.println(jackSparrow);

        System.out.println("**********************");
        Objects.requireNonNull(PirateGame.getTowns(0)).forEach(System.out::println);
        System.out.println("**********************");
        PirateGame.getTowns(1).forEach(System.out::println);

        var console = new GameConsole<>(new PirateGame("Pirate of the Caribbean"));
        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }

    private static void printWeapon(Weapon weapon) {
        System.out.println("Weapon : " + weapon.name() +
                " - Hit points = " + weapon.getHitPoints() +
                " - Min Level = " + weapon.getMinLevel());
    }
}

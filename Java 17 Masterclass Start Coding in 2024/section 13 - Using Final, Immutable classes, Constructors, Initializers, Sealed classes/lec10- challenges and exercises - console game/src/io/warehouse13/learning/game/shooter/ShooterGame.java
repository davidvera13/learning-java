package io.warehouse13.learning.game.shooter;

import io.warehouse13.learning.game.Game;
import io.warehouse13.learning.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;


public class ShooterGame extends Game<Shooter> {

    public ShooterGame(String gameName) {
        super(gameName);
    }

    @Override
    public Shooter createPlayer(String name) {
        return new Shooter(name);
    }

    @Override
    public Map<Character, GameAction> getGamections(int playerIndex) {
        var map = new LinkedHashMap<>(Map.of(
                'F', new GameAction('F', "Find Prize", this::findPrize),
                'S', new GameAction('F', "Use your weapon ", this::useWeapon)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    public boolean findPrize(int playerIndex) {
        return getPlayer(playerIndex).findPrize();
    }

    public boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon("Beretta 92FS Brigadier");
    }
}
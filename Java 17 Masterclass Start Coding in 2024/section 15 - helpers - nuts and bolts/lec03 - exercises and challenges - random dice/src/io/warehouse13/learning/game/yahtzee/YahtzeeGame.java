package io.warehouse13.learning.game.yahtzee;

import io.warehouse13.learning.game.Game;
import io.warehouse13.learning.game.GameAction;

import java.util.LinkedHashMap;
import java.util.Map;

public class YahtzeeGame extends Game<YahtzeePlayer> {
    public YahtzeeGame(String gameName) {
        super(gameName);
    }

    @Override
    public YahtzeePlayer createPlayer(String name) {
        return new YahtzeePlayer(name);
    }

    @Override
    public Map<Character, GameAction> getGameActions(int playerIndex) {
        Map<Character, GameAction> map = new LinkedHashMap<>(Map.of(
                'R',
                new GameAction('R', "Roll Dice", this::rollDice)
        ));
        map.putAll(getStandardActions());
        return map;
    }

    private boolean rollDice(int playerIndex) {

        return getPlayer(playerIndex).rollDiceAndSelect();
    }

}

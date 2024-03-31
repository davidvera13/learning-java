package io.warehouse13.learning.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Game<T extends  Player> {
    private final String gameName;
    private final List<T> players = new ArrayList<>();
    private Map<Character, GameAction> standardActions;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public Map<Character, GameAction> getStandardActions() {
        if(standardActions == null) {
            //'I', new GameAction('I', "Print player information", (id) -> this.printPlayer(id)),
            //'Q',new GameAction('Q', "Quit game", (id) -> this.quitGame(id)
            standardActions = new LinkedHashMap<>(Map.of(
                    'I', new GameAction('I', "Print player information", this::printPlayer),
                    'Q',new GameAction('Q', "Quit game", this::quitGame)
            ));
        }
        return standardActions;
    }

    private boolean printPlayer(int playerIndex) {
        Player player = players.get(playerIndex);
        System.out.println(player);
        return false;
    }

    private boolean quitGame(int playerIndex) {
        Player player = players.get(playerIndex);
        System.out.println("Sorry to see you go " + player.name());
        return true;
    }

    public abstract T createPlayer(String name);
    public abstract Map<Character, GameAction> getGamections(int playerIndex);

    final int addPlayer(String name) {
        T player = createPlayer(name);
        if(player != null) {
            players.add(player);
            return players.size() - 1;
        }
        return  - 1;
    }

    protected final T getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    public boolean executeGameAction(int player, GameAction action) {
        return action.action().test(player);
    }
}

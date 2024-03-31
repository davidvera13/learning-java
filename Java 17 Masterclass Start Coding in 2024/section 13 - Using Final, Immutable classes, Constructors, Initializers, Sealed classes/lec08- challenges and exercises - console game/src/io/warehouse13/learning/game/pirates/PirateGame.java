package io.warehouse13.learning.game.pirates;

import io.warehouse13.learning.game.Game;
import io.warehouse13.learning.game.GameAction;
import io.warehouse13.learning.game.Weapon;
import io.warehouse13.learning.game.shooter.Shooter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class PirateGame extends Game<Pirate> {
    private static final List<List<String>> levelMap;

    //**************** using static initializer ***********************/
    static {
        levelMap = new ArrayList<>();
        System.out.println("Loading data...");
        loadData();
        if(levelMap.isEmpty())
            throw new RuntimeException("Could not load data, try again...");
        System.out.println("Data were loaded!");
    }

    public PirateGame(String gameName) {
        super(gameName);
    }

    @Override
    public Pirate createPlayer(String name) {
        return new Pirate(name);
    }


    @Override
    public Map<Character, GameAction> getGamections(int playerIndex) {
        Pirate pirate = getPlayer(playerIndex);
        System.out.println(pirate);
        List<Weapon> weapons = Weapon.getWeaponsByLevel(pirate.value("level"));

        Map<Character, GameAction> map = new LinkedHashMap<>();
        for (Weapon weapon : weapons) {
            char init = weapon.name().charAt(0);
            map.put(init, new GameAction(init, "Use " + weapon,
                    this::useWeapon));
        }
        map.putAll(getStandardActions());
        return map;
    }
    private static void loadData() {
        // Level 1 Towns
        levelMap.add(new ArrayList<>(List.of(
                "Bridgetown, Barbados",
                "Fitts Village, Barbados",
                "Holetown, Barbados"
        )));
        // Level 2 Towns
        levelMap.add(new ArrayList<>(List.of(
                "Fort-de-France, Martinique",
                "Sainte-Anne, Martinique",
                "Le Vauclin, Martinique"
        )));
    }

    public static List<String> getTowns(int level) {
        if (level <= (levelMap.size() - 1)) {
            return levelMap.get(level);
        }
        return null;
    }


    public boolean useWeapon(int playerIndex) {
        return getPlayer(playerIndex).useWeapon();
    }

    @Override
    public boolean executeGameAction(int playerIndex, GameAction action) {
        getPlayer(playerIndex).setCurrentWeapon(Weapon.getWeaponByChar(action.key()));
        return super.executeGameAction(playerIndex, action);
    }
}


package io.warehouse13.learning.game.pirates;

import io.warehouse13.learning.game.Weapon;

public final class Soldier extends Combatant {

    public Soldier(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}

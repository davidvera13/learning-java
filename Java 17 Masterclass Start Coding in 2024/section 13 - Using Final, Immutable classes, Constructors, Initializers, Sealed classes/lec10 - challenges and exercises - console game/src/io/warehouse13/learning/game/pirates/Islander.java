package io.warehouse13.learning.game.pirates;

import io.warehouse13.learning.game.Weapon;

public final class Islander extends Combatant {

    public Islander(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}

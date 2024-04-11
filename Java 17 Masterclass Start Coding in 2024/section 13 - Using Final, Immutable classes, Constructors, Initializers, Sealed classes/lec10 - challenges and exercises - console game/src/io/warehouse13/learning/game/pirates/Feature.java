package io.warehouse13.learning.game.pirates;

public enum Feature {
    ALLIGATOR(-45),
    ALOE(5),
    JELLY_FISH(-10),
    PINEAPPLE(10),
    SNAKE(-25),
    SPRING(25),
    SUN_POISON(-15);

    private final int health;

    Feature(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}

package io.warehouse13.learning.game.poker;

public enum Ranking {
    // from worst to best
    NONE, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}

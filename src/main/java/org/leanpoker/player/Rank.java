package org.leanpoker.player;

/**
 * Created by roland on 2014.04.05..
 */
public enum Rank {
    HIGH_CARD(0),
    PAIR(1),
    TWO_PAIR(2),
    TREE_OF_A_KIND(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7),
    STRAIGHT_FLUSH(8);

    private int value;

    private Rank(int value) {
        this.value = value;
    }

    public static Rank getByValue(int value) {
        for (Rank r : Rank.values()) {
            if (r.value == value)
                return r;
        }
        throw new IllegalArgumentException();
    }

}

package edu.neumont.teamgift.clue.board;

import java.util.Random;

/**
 * A simple die.
 */
public class Die {

    /**
     * The amount of sides on the die.
     */
    private static final int SIDES_COUNT = 6;

    /**
     * Get a random face value on the die.
     *
     * @return The side of the die rolled.
     */
    public final int rollDie() {
        Random r = new Random();
        return (r.nextInt(SIDES_COUNT) + 1) + (r.nextInt(SIDES_COUNT) + 1);
    }

}

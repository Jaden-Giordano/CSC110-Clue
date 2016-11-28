package edu.neumont.teamgift.clue.interfaces;

/**
 * An interface for objects that need an update function.
 */
public interface Updatable {
    /**
     * Called first.
     */
    void start();

    /**
     * Called every tick.
     */
    void update();
}

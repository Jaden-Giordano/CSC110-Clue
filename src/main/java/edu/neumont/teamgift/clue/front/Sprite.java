package edu.neumont.teamgift.clue.front;

import edu.neumont.teamgift.clue.Vector3i;

/**
 * An image that can be drawn to the screen.
 */
public class Sprite {

    /**
     * Color.
     */
    private final Vector3i color;

    /**
     * If it is colored or if its an image.
     */
    private boolean colored;

    /**
     * Load a sprite from a file.
     *
     * @param pathToFile The path to the image.
     */
    public Sprite(final String pathToFile) {
        // TODO use actual images.
        colored = true;
        //noinspection CheckStyle
        color = new Vector3i(255, 0, 0);
    }

    /**
     * Gets whether the sprite is a color or an image.
     *
     * @return If color or image.
     */
    public final boolean isColored() {
        return colored;
    }

    /**
     * Get the color of the sprite.
     *
     * @return The color (red, green, blue).
     */
    public final Vector3i getColor() {
        return color;
    }

}

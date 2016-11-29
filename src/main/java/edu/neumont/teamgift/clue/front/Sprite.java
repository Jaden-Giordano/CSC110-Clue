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
     * The texture id for drawing.
     */
    private int textureID;

    /**
     * Create a sprite with texture id.
     *
     * @param texID The id of the texture
     */
    public Sprite(final int texID) {
        this.textureID = texID;

        colored = this.textureID == -1;

        this.color = Vector3i.zero();
    }

    /**
     * Create a sprite that is a solid color.
     *
     * @param sColor The color of the sprite.
     */
    public Sprite(final Vector3i sColor) {
        colored = true;

        this.color = sColor;
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

    /**
     * Get the texture id.
     *
     * @return The texture id.
     */
    public final int getTextureID() {
        return textureID;
    }

}

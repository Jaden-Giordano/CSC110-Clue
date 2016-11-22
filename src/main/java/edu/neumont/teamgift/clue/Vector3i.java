package edu.neumont.teamgift.clue;

/**
 * A set of 3 points.
 */
public class Vector3i {

    /**
     * The 3 coordinates.
     */
    @SuppressWarnings("WeakerAccess") public int x, y, z;

    /**
     * Create a new vector with 3 points.
     *
     * @param xPosition The x position.
     * @param yPosition The y position.
     * @param zPosition The z position.
     */
    public Vector3i(final int xPosition, final int yPosition, final int zPosition) {
        this.x = xPosition;
        this.y = yPosition;
        this.z = zPosition;
    }

    /**
     * Create a new vector with coordinates (0, 0, 0).
     */
    public static final Vector3i zero() {
        return new Vector3i(0, 0, 0);
    }

}

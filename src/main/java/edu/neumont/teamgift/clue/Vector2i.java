package edu.neumont.teamgift.clue;

/**
 * Vector containing two points relating to coordinates in a tile array.
 * Contains basic math functions as well.
 */
@SuppressWarnings({"WeakerAccess", "CheckStyle"})
public class Vector2i implements Comparable<Vector2i> {

    /**
     * 'X' coordinate and 'Y' coordinate of vector.
     */
    @SuppressWarnings("CanBeFinal")
    public int x;

    @SuppressWarnings("CanBeFinal")
    public int y;

    /**
     * Constructor for vector with specific 'X' and 'Y' coordinates.
     *
     * @param xPosition The 'X' coordinate.
     * @param yPosition The 'Y' coordinate.
     */
    public Vector2i(final int xPosition, final int yPosition) {
        this.x = xPosition;
        this.y = yPosition;
    }

    /**
     * Default vector with coordinates (0, 0).
     *
     * @return New vector with coordinates (0, 0).
     */
    public static Vector2i zero() {
        return new Vector2i(0, 0);
    }

    /**
     * Add two vectors together using basic vector addition.
     *
     * @param a The first Vector.
     * @param b The second Vector.
     * @return Returns the sum of the vectors.
     */
    static Vector2i add(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x + b.x, a.y + b.y);
    }

    /**
     * Subtract two vectors using basic vector subtraction.
     *
     * @param a The first vector.
     * @param b The second vector.
     * @return Returns the first vector subtracted by te second.
     */
    static Vector2i sub(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x - b.x, a.y - b.y);
    }

    /**
     * Multiply two vectors using basic vector multiplication.
     *
     * @param a The first vector.
     * @param b The second vector.
     * @return Returns the product of the vectors.
     */
    static Vector2i multiply(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x * b.x, a.y * b.y);
    }

    /**
     * Divides two vectors using basic vector division.
     *
     * @param a The first vector.
     * @param b The second vector.
     * @return Returns the quotient of the vectors.
     */
    @SuppressWarnings("unused")
    public static Vector2i divide(final Vector2i a, final Vector2i b) {
        if (b.x == 0 || b.y == 0) {
            throw new ArithmeticException("Cannot divide by 0.");
        }

        return new Vector2i(a.x / b.x, a.y / b.y);
    }

    /**
     * Gets the distance between two points, disregarding diagonals.
     *
     * @param a The starting vector.
     * @param b The ending vector.
     * @return Returns the distance between the two vectors.
     */
    public static int distance(final Vector2i a, final Vector2i b) {
        return (b.x - a.x) + (b.y - a.y);
    }

    /**
     * Adds this vector to another.
     *
     * @param b The other vector.
     * @return A new vector of the sum.
     */
    @SuppressWarnings("unused")
    public final Vector2i add(final Vector2i b) {
        return add(this, b);
    }

    /**
     * Subtracts this vector by another.
     *
     * @param b The other vector.
     * @return A new vector of this vector subtracted by the other vector.
     */
    public final Vector2i sub(final Vector2i b) {
        return sub(this, b);
    }

    /**
     * Multiplies this vector by another.
     *
     * @param b The other vector.
     * @return A new vector for the product of the vectors.
     */
    @SuppressWarnings("unused")
    public final Vector2i multiply(final Vector2i b) {
        return multiply(this, b);
    }

    /**
     * Divides this vector by another.
     *
     * @param b The other vector.
     * @return A new vector for the quotient of the vectors.
     * @throws ArithmeticException Denominator cannot contain a zero.
     */
    @SuppressWarnings("unused")
    public final Vector2i divide(final Vector2i b) throws ArithmeticException {
        return add(this, b);
    }

    @Override
    public final int compareTo(final Vector2i o) {
        if (x == o.x && y == o.y) {
            return 0;
        }

        return 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

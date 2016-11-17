package edu.neumont.teamgift.clue;

/**
 * Vector containing two points relating to coordinates in a tile array.
 * Contains basic math functions as well.
 */
@SuppressWarnings("WeakerAccess")
public class Vector2i implements Comparable<Vector2i> {

    /**
     * 'X' coordinate and 'Y' coordinate of vector.
     */
    public int x = 0, y = 0;

    /**
     * Default vector with coordinates (0, 0).
     */
    public static final Vector2i zero() {
        return new Vector2i(0, 0);
    }

    /**
     * Constructor for vector with specific 'X' and 'Y' coordinates.
     * @param a The 'X' coordinate.
     * @param b The 'Y' coordinate.
     */
    public Vector2i(final int a, final int b) {
        this.x = a;
        this.y = b;
    }

    /**
     * Add two vectors together using basic vector addition.
     * @param a The first Vector.
     * @param b The second Vector.
     * @return Returns the sum of the vectors
     */
    static Vector2i add(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x + b.x, a.y + b.y);
    }

    /**
     * Subtract two vectors using basic vector subtraction.
     * @param a The first vector.
     * @param b The second vector.
     * @return Returns the first vector subtracted by te second.
     */
    static Vector2i sub(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x - b.x, a.y - b.y);
    }

    /**
     * Multiply two vectors using basic vector multiplication.
     * @param a The first vector.
     * @param b The second vector.
     * @return
     */
    static Vector2i multiply(final Vector2i a, final Vector2i b) {
        return new Vector2i(a.x * b.x, a.y * b.y);
    }

    public static Vector2i divide(Vector2i a, Vector2i b) {
        if (b.x == 0 || b.y == 0)
            throw new ArithmeticException("Cannot divide by 0.");

        return new Vector2i(a.x / b.x, a.y / b.y);
    }

    static int distance(Vector2i a, Vector2i b) {
        return (b.x - a.x) + (b.y - a.y);
    }

    public Vector2i add(Vector2i b) {
        return add(this, b);
    }

    public Vector2i sub(Vector2i b) {
        return sub(this, b);
    }

    public Vector2i multiply(Vector2i b) {
        return multiply(this, b);
    }

    public Vector2i divide(Vector2i b) throws ArithmeticException {
        return add(this, b);
    }

    @Override
    public int compareTo(Vector2i o) {
        if (x == o.x && y == o.y)
            return 0;

        return 1;
    }
}

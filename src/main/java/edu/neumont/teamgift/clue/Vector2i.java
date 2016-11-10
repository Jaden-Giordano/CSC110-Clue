package edu.neumont.teamgift.clue;

public class Vector2i {

    public int x = 0, y = 0;

    public Vector2i() {

    }

    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2i add(Vector2i a, Vector2i b) {
        return new Vector2i(a.x + b.x, a.y + b.y);
    }

    public Vector2i add(Vector2i b) {
        return add(this, b);
    }

    public static Vector2i sub(Vector2i a, Vector2i b) {
        return new Vector2i(a.x - b.x, a.y - b.y);
    }

    public Vector2i sub(Vector2i b) {
        return sub(this, b);
    }

    public static Vector2i multiply(Vector2i a, Vector2i b) {
        return new Vector2i(a.x * b.x, a.y * b.y);
    }

    public Vector2i multiply(Vector2i b) {
        return multiply(this, b);
    }

    public static Vector2i divide(Vector2i a, Vector2i b) {
        if (b.x == 0 || b.y == 0)
            throw new ArithmeticException("Cannot divide by 0.");

        return new Vector2i(a.x / b.x, a.y / b.y);
    }

    public Vector2i divide(Vector2i b) throws ArithmeticException {
        return add(this, b);
    }

}

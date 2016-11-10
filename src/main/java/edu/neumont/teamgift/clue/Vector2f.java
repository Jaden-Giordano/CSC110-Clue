package edu.neumont.teamgift.clue;

public class Vector2f {

    public float x = 0, y = 0;

    public Vector2f() {

    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2f add(Vector2f a, Vector2f b) {
        return new Vector2f(a.x + b.x, a.y + b.y);
    }

    public Vector2f add(Vector2f b) {
        return add(this, b);
    }

    public static Vector2f sub(Vector2f a, Vector2f b) {
        return new Vector2f(a.x - b.x, a.y - b.y);
    }

    public Vector2f sub(Vector2f b) {
        return sub(this, b);
    }

    public static Vector2f multiply(Vector2f a, Vector2f b) {
        return new Vector2f(a.x * b.x, a.y * b.y);
    }

    public Vector2f multiply(Vector2f b) {
        return multiply(this, b);
    }

    public static Vector2f divide(Vector2f a, Vector2f b) {
        if (b.x == 0 || b.y == 0)
            throw new ArithmeticException("Cannot divide by 0.");

        return new Vector2f(a.x / b.x, a.y / b.y);
    }

    public Vector2f divide(Vector2f b) throws ArithmeticException {
        return add(this, b);
    }

}

package aoc24.misc;

public class Point {
    public int x;
    public int y;

    public boolean equals(Point p) {
        if (p == null) return false;
        return x == p.x && y == p.y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add (Point p) { // factory
        return new Point(x + p.x, y + p.y);
    }
}

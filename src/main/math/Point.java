package src.main.math;

public class Point extends java.awt.Point {
    public Point(double x, double y) {
        super((int)x, (int)y);
    }

    public Point(java.awt.Point p) {
        super(p);
    }

    public double distance(Point p) {
        return Math.sqrt(
            (p.getX() - this.getX()) * (p.getX() - this.getX()) +
            (p.getY() - this.getY()) * (p.getY() - this.getY())
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Point scaledVector(Point start, Point end, double scaleFactor) {
        int scaledX = (int)(start.getX() + (end.getX() - start.getX()) * scaleFactor);
        int scaledY = (int)(start.getY() + (end.getX() - start.getY()) * scaleFactor);
        return new Point(scaledX, scaledY);
    }
}

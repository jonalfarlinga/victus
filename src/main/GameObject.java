package src.main;
import src.main.math.Point;

import java.awt.Graphics;

public abstract class GameObject {
    private int depth, width;
    private double angle;
    private Point frontLeft, frontRight, backLeft, backRight;
    private ID id;
    protected boolean locked;
    private Point center;

    public GameObject(Point p, int width, int depth, ID id) {
        this.center = p;
        this.id = id;
        this.depth = depth;
        this.width = width;
        angle = 0;
        locked = true;
        frontLeft = new Point(p.x-Game.MU,(int)p.y-depth/2);
        frontRight = new Point(p.x+Game.MU,(int)p.y-depth/2);
        backLeft = new Point(p.x-Game.MU,(int)p.y+depth/2);
        backRight = new Point(p.x+Game.MU,(int)p.y+depth/2);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void rotate(double radians) {
        angle += radians;
        if (radians > 2 * Math.PI) {
            radians -= 2 * Math.PI;
        } else if(angle < 0) {
            angle += 2 * Math.PI;
        }

        Point[] vertices = {
            frontLeft,
            frontRight,
            backLeft,
            backRight
        };

        for (Point vertex : vertices) {
            double cosAngle = Math.cos(angle);
            double sinAngle = Math.sin(angle);

            double translatedX = vertex.x - center.x;
            double translatedY = vertex.y - center.y;

            vertex.x = (int)(
                cosAngle * translatedX - sinAngle * translatedY + center.x
            );
            vertex.y = (int)(
                sinAngle * translatedX + cosAngle * translatedY + center.y
            );
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setX(int x) {
        if (!locked) {
            center.setX(x);
        }
    }

    public void setY(int y) {
        if (!locked) {
            center.setY(y);
        }
    }

    public int getX() {
        return (int)center.getX();
    }

    public int getY() {
        return (int)center.getY();
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public ID getId() {
        return this.id;
    }

    public Point getCenter() {
        return center;
    }

    public Point getFrontRight() {
        return frontRight;
    }

    public Point getFrontLeft() {
        return frontLeft;
    }

    public Point getBackLeft() {
        return backLeft;
    }

    public Point getBackRight() {
        return backRight;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double radians) {
        angle = radians;
        this.rotate(0);
    }

    public void move(int x, int y, double radians) {
        center.setX(x);
        center.setY(y);
        frontLeft = new Point(center.x-width/2,(int)center.y-depth/2);
        frontRight = new Point(center.x+width/2,(int)center.y-depth/2);
        backLeft = new Point(center.x-width/2,(int)center.y+depth/2);
        backRight = new Point(center.x+width/2,(int)center.y+depth/2);
        this.rotate(radians);
    }

    public void move(int x, int y) {
        move(x, y, 0);
    }

    public void move(Point p) {
        move(p.x, p.y, 0);
    }

    public int clamp(int value, int max, int min) {

        if (value < min) return min;
        else if (value > max) return max;
        else return value;
    }

    // Check if a point is inside the rectangle
    // Separating Axis Theorem
    public boolean collidePoint(Point p) {
        Point[] vertices = {frontLeft, frontRight, backRight, backLeft};

        for (int i = 0; i < 4; i++) {
            Point p1 = vertices[i];
            Point p2 = vertices[(i + 1) % 4];

            double axisX = p2.x - p1.x;
            double axisY = p2.y - p1.y;

            double projection = (p.x - p1.x) * axisX + (p.y - p1.y) * axisY;
            double axisLength = axisX * axisX + axisY * axisY;

            double min = Math.min(0, projection / axisLength);
            double max = Math.max(axisLength, projection / axisLength);

            double pointProjection = (p.x - p1.x) * axisX + (p.y - p1.y) * axisY;

            if (!(pointProjection >= min && pointProjection <= max)) {
                return false; // Separation found
            }
        }
        return true; // No separation found, point is inside the rectangle
    }
}

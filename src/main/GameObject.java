package src.main;
import src.main.math.Point;

import java.awt.Graphics;

public abstract class GameObject {
    protected int height, width, angle;
    protected Point frontLeft, frontRight, backLeft, backRight;
    protected ID id;
    protected boolean locked;
    protected Point center;

    public GameObject(Point p, int width, int height, ID id) {
        this.center = p;
        this.id = id;
        this.height = height;
        this.width = width;
        angle = 0;
        locked = true;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void rotate(int degrees);

    public void setX(int x) {
        center.setX(x);
    }

    public void setY(int y) {
        center.setY(y);
    }

    public int getX() {
        return (int)center.getX();
    }

    public int getY() {
        return (int)center.getY();
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

    public int getAngle() {
        return angle;
    }

    public void setAngle(int degrees) {
        this.angle = degrees;
    }

    public void transform(int degrees) {

    }

    public void move(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    public void move(Point p) {
        center = p;
    }

    public int clamp(int value, int max, int min) {

        if (value < min) return min;
        else if (value > max) return max;
        else return value;
    }

    public boolean collidePoint(Point p) {
        System.out.print("This Function Sucks src.main.GameObject.collidePoint");
        return false;
    }
}

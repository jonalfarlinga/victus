package src.main;

import java.awt.Graphics;
import java.awt.Point;

public abstract class GameObject {
    protected int x, y, height, width, angle;
    protected Point frontLeft, frontRight, backLeft, backRight;
    protected ID id;
    protected boolean locked;

    public GameObject(int x, int y, int width, int height, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.height = height;
        this.width = width;
        angle = 0;
        locked = true;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public ID getId() {
        return this.id;
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

    public void transform(int degrees) {

    }

    public void traverse(int x, int y) {

    }
}

package src.main;

import java.awt.Graphics;

import src.main.math.Point;

import java.awt.Color;

public class Player extends GameObject {
    // Debugging entity

    public Player(int x, int y, ID id) {
        super(new Point(x, y), 32, 32, id);
    }

    public void tick() {
        setX(Game.clamp(getX(), 0, Game.WIDTH-48));
        setY(Game.clamp(getY(), 0, Game.HEIGHT-72));
    }

    public void render(Graphics g) {
        if (getId() == ID.Player1) g.setColor(Color.white);
            g.fillRect(getX() - getWidth() / 2, getY() - getDepth() / 2, 32, 32);
            g.setColor(Color.red);
            g.fillRect(getX(), getY(), 8, 8);
    }

    public void rotate(int degrees) {
        System.out.print("This function sucks. Don't call it");
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }
}

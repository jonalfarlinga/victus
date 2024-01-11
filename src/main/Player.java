package src.main;

import java.awt.Graphics;

import src.main.math.Point;

import java.awt.Color;

public class Player extends GameObject {
    // Debugging entity

    public Player(int x, int y, ID id) {
        super(new Point(x, y), 32, 32, id);
        height = 32;
        width = 32;
    }

    public void tick() {
        center.x = Game.clamp(center.x, 0, Game.WIDTH-48);
        center.y = Game.clamp(center.y, 0, Game.HEIGHT-72);
    }

    public void render(Graphics g) {
        if (id == ID.Player1) g.setColor(Color.white);
            g.fillRect(center.x - width / 2, center.y - height / 2, 32, 32);
            g.setColor(Color.red);
            g.fillRect(center.x, center.y, 8, 8);
    }

    @Override
    public void rotate(int degrees) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    }
}

package src.main;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    // Debugging entity

    public Player(int x, int y, ID id) {
        super(x, y, 32, 32, id);
        height = 32;
        width = 32;
    }

    public void tick() {
        x = Game.clamp(x, 0, Game.WIDTH-48);
        y = Game.clamp(y, 0, Game.HEIGHT-72);
    }

    public void render(Graphics g) {
        if (id == ID.Player1) g.setColor(Color.white);
            g.fillRect(x - width / 2, y - height / 2, 32, 32);
            g.setColor(Color.red);
            g.fillRect(x, y, 8, 8);
    }
}

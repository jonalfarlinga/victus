package src.main;

import java.awt.Graphics;
import java.awt.Color;

public class HUD {
    //public static int HEALTH = 100;
    //public static int SCORE = 0;

    public void tick() {
        //HEALTH = Game.clamp(HEALTH, 0, 100);
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(32,32, (int)(32*17.5), (int)(32*11.5));
        /* g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15,15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);
        g.drawString("Score: " + SCORE, 15, 60); */
        }
}

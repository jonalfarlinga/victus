package src.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Troop extends GameObject {
    private boolean ranged;
    private int depth;
    private BufferedImage img;

    public Troop(int x, int y, ID id) {
        super(x, y, id);
    }

    public abstract void combatResults();
    public abstract void move();

    public boolean getRanged() {
        return ranged;
    }

    public int getDepth() {
        return depth;
    }

    public BufferedImage getImg() {
        return img;
    }
}

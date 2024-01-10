package src.main.troops;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import src.main.Game;
import src.main.GameObject;
import src.main.ID;

public abstract class Troop extends GameObject {
    private boolean ranged;
    private int depth;
    private BufferedImage img;

    public Troop(int x, int y, int depth, boolean ranged, ID id) {
        super(x, y, 2*Game.MU, depth, id);
        this.ranged = ranged;
        this.depth = depth;
        frontLeft = new Point(x-Game.MU,(int)y-depth/2);
        frontRight = new Point(x+Game.MU,(int)y-depth/2);
        backLeft = new Point(x-Game.MU,(int)y+depth/2);
        backRight = new Point(x+Game.MU,(int)y+depth/2);
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

    public Troop createShadow() {
        return new ShadowTroop();
    }
}

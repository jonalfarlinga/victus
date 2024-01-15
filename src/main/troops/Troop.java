package src.main.troops;
import src.main.math.Point;

import java.awt.image.BufferedImage;

import src.main.Game;
import src.main.GameObject;
import src.main.ID;

public abstract class Troop extends GameObject {
    private boolean ranged;
    private BufferedImage img;
    private int distance;
    private ShadowTroop shadow;

    public Troop(Point p, int depth, int distance, boolean ranged, ID id) {
        super(p, 2*Game.MU, depth, id);
        System.out.println("initialized");
        this.ranged = ranged;
        this.distance = distance;
    }

    public abstract void combatResults();

    public int getDist() {
        return distance;
    }

    public boolean getRanged() {
        return ranged;
    }

    public BufferedImage getImg() {
        return img;
    }

    public ShadowTroop createShadow() {
        return new ShadowTroop(new Point(getCenter()), getDepth(), distance, getId(), this);
    }
}

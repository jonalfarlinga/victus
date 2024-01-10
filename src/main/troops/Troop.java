package src.main.troops;
import src.main.math.Point;

import java.awt.image.BufferedImage;

import src.main.Game;
import src.main.GameObject;
import src.main.ID;

public abstract class Troop extends GameObject {
    private boolean ranged;
    private int depth;
    private BufferedImage img;
    private int distance;

    public Troop(Point p, int depth, int distance, boolean ranged, ID id) {
        super(p, 2*Game.MU, depth, id);
        this.ranged = ranged;
        this.depth = depth;
        this.distance = distance;
        frontLeft = new Point(p.x-Game.MU,(int)p.y-depth/2);
        frontRight = new Point(p.x+Game.MU,(int)p.y-depth/2);
        backLeft = new Point(p.x-Game.MU,(int)p.y+depth/2);
        backRight = new Point(p.x+Game.MU,(int)p.y+depth/2);
    }

    public abstract void combatResults();

    public int getDist() {
        return distance;
    }

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
        return new ShadowTroop(this.center, depth, distance, id, this);
    }

    public void rotate(int degrees) {

    }
}

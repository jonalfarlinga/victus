package src.main.troops;
import src.main.math.Point;

import java.awt.Color;
import java.awt.Graphics;

import src.main.ID;

public class ShadowTroop extends Troop {
    private Troop parent;

    public ShadowTroop(Point p, int depth, int distance, ID id, Troop parent) {
        super(p, depth, distance, false, id);
        this.parent = parent;
        this.locked = false;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void combatResults() {
        System.err.println("This is a ShadowTroop. You should not call this function.");
        throw new UnsupportedOperationException("Unimplemented method 'combatResults'");
    }

    public void tick() {
        // TODO Auto-generated method stub
    }

    public void render(Graphics g) {
        int[] xArray = {
            (int)getFrontLeft().getX(),
            (int)getFrontRight().getX(),
            (int)getBackRight().getX(),
            (int)getBackLeft().getX()
        };
        int[] yArray = {
            (int)getFrontLeft().getY(),
            (int)getFrontRight().getY(),
            (int)getBackRight().getY(),
            (int)getBackLeft().getY()
        };
        g.setColor(Color.LIGHT_GRAY);
        int dist = super.getDist();
        g.fillOval(parent.getX() - dist, parent.getY() - dist, dist * 2, dist * 2);
        parent.render(g);
        g.setColor(Color.RED);
        g.fillPolygon(xArray, yArray, 4);
    }

    public void move(Point p, double radians) {
        int distance = parent.getDist();
        double thisDist = parent.getCenter().distance(p);
        if (thisDist > distance) {
            double uvX = (p.getX() - parent.getX()) / thisDist;
            double uvY = (p.getY() - parent.getY()) / thisDist;
            p = new Point(
                (int) (uvX * distance) + parent.getX(),
                (int) (uvY * distance) + parent.getY()
            );
        }
        super.move((int)p.getX(), (int)p.getY(), 0);
    }

    public void move(int x, int y, double radians) {
        move(new Point(x, y), 0);
    }
}

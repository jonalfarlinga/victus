package src.main.troops;

import java.awt.Color;
import java.awt.Graphics;

import src.main.ID;
import src.main.math.Point;

public class BlankTroop extends Troop {

    public BlankTroop(int x, int y, int depth, int distance, ID id) {
        super(new Point(x, y), depth, distance, false, id);
    }

    public void combatResults() {
        System.err.println("This is a BlankTroop. You should not call this function.");
        throw new UnsupportedOperationException("Unimplemented method 'combatResults'");
    }

    @Override
    public void tick() {
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
        g.setColor(Color.BLACK);
        g.fillPolygon(xArray, yArray, 4);
    }

    public void setLocked(boolean locked) {
        this.createShadow();
    }
}

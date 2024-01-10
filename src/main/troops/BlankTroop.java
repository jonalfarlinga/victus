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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    public void render(Graphics g) {
        int[] xArray = {
            (int)frontLeft.getX(),
            (int)frontRight.getX(),
            (int)backLeft.getX(),
            (int)backRight.getX()
        };
        int[] yArray = {
            (int)frontLeft.getY(),
            (int)frontRight.getY(),
            (int)backLeft.getY(),
            (int)backRight.getY()
        };
        g.setColor(Color.YELLOW);
        g.fillPolygon(xArray, yArray, 4);
    }
}

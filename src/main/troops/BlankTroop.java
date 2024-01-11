package src.main.troops;

import java.awt.Color;
import java.awt.Graphics;

import src.main.Game;
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
        frontLeft = new Point(center.x-Game.MU,(int)center.y-super.getDepth()/2);
        frontRight = new Point(center.x+Game.MU,(int)center.y-super.getDepth()/2);
        backLeft = new Point(center.x-Game.MU,(int)center.y+super.getDepth()/2);
        backRight = new Point(center.x+Game.MU,(int)center.y+super.getDepth()/2);
    }

    public void render(Graphics g) {
        int[] xArray = {
            (int)frontLeft.getX(),
            (int)frontRight.getX(),
            (int)backRight.getX(),
            (int)backLeft.getX()
        };
        int[] yArray = {
            (int)frontLeft.getY(),
            (int)frontRight.getY(),
            (int)backRight.getY(),
            (int)backLeft.getY()
        };
        g.setColor(Color.BLACK);
        g.fillPolygon(xArray, yArray, 4);
    }
}

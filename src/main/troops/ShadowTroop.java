package src.main.troops;

import java.awt.Color;
import java.awt.Graphics;

import src.main.ID;

public class ShadowTroop extends Troop {
    private Troop parent;

    public ShadowTroop(int x, int y, int depth, ID id, Troop parent) {
        super(x, y, depth, false, id);
        this.parent = parent;
    }

    @Override
    public void combatResults() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'combatResults'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tick'");
    }

    @Override
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
        g.setColor(Color.LIGHT_GRAY);
        g.drawPolygon(xArray, yArray, 4);
    }

}

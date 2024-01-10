package src.main.troops;
import src.main.math.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.util.stream.DoubleStream;

import src.main.ID;

public class ShadowTroop extends Troop {
    private Troop parent;

    public ShadowTroop(Point p, int depth, int distance, ID id, Troop parent) {
        super(p, depth, distance, false, id);
        this.parent = parent;
    }

    public void combatResults() {
        System.err.println("This is a ShadowTroop. You should not call this function.");
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
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(parent.getX(), parent.getY(), super.getDist(), super.getDist());
        g.setColor(Color.RED);
        g.fillPolygon(xArray, yArray, 4);
    }

    public void move(Point p) {

        double maxDistance = DoubleStream.of(
            parent.getCenter().distance(this.frontLeft),
            parent.getCenter().distance(this.frontRight),
            parent.getCenter().distance(this.backLeft),
            parent.getCenter().distance(this.backRight)
        ).max().getAsDouble();

        double distance = this.getDist();
        if (maxDistance > distance) {
            double scaleFactor = distance / maxDistance;
            this.center = Point.scaledVector(parent.getCenter(), p, scaleFactor);
        } else {
            this.center = p;
        }
    }

    public boolean collidePoint(Point p) {
        System.out.print("This function sucks src.main.troops.ShadowTroop.collidePoint");
        return true;
    }
}

package src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import src.main.math.Point;

import java.awt.event.MouseEvent;

public class InputListener extends KeyAdapter implements MouseListener, MouseWheelListener, MouseMotionListener {
    private ObjectHandler handler;

    public InputListener(ObjectHandler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i=0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player1) {
                if (key == KeyEvent.VK_W) tempObject.setY(tempObject.getY()-5);
                if (key == KeyEvent.VK_S) tempObject.setY(tempObject.getY()+5);
                if (key == KeyEvent.VK_A) tempObject.setY(tempObject.getX()-5);
                if (key == KeyEvent.VK_D) tempObject.setY(tempObject.getX()+5);
            }
        }

        System.out.println(key);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i=0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player1) {
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        int posX = e.getX();
        int posY = e.getY();

        for (int i=0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (!tempObject.isLocked()) {
                System.out.println(tempObject);
                tempObject.move(posX, posY, 0);
            }
        }
    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        Point p = new Point(e.getPoint());


    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = new Point(e.getPoint());

        for (int i=0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.collidePoint(p) && tempObject.getId() == ID.Player1) {
                tempObject.setLocked(false);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        for (int i=0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            tempObject.setLocked(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotations = e.getWheelRotation();

        for (int i=0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (!tempObject.isLocked()) {
                tempObject.move(
                    tempObject.getX(),
                    tempObject.getY(),
                    Math.PI/16 * rotations
                );
            }
        }
    }
}

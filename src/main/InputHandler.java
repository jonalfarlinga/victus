package src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class InputHandler extends KeyAdapter implements MouseListener, MouseMotionListener {
    private Handler handler;

    public InputHandler(Handler handler) {
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

        for (int i=0; i< handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            tempObject.setX(posX);
            tempObject.setY(posY);
        }
    }

    public void mouseMoved(java.awt.event.MouseEvent e) {

    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("clicked");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }
}

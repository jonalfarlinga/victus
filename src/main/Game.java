package src.main;

// import java.util.Random;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import src.main.troops.BlankTroop;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;

    private Thread thread;
    private boolean running = false;

    private ObjectHandler handler;
    //private Random r;
    private HUD hud;
    private BufferedImage background;
    protected boolean endTurn;
    public static int MU;

    public Game() {
        MU = 20;
        endTurn = false;
        handler = new ObjectHandler();
        hud = new HUD();
        //r = new Random();
        InputListener input = new InputListener(handler);
        this.addMouseMotionListener(input);
        this.addKeyListener(input);
        this.addMouseListener(input);
        this.addMouseWheelListener(input);
        String localDir = System.getProperty("user.dir");
        File file = new File(localDir + "/img/background.png");
        try {  // must handle the IOException just in case
            background = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Window(WIDTH, HEIGHT, "Let's build a game!", this);

        handler.addObject(new BlankTroop(200, 200, 30, MU * 4, ID.Player1));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void tick () {
        if (endTurn) {
            turn();
            endTurn = false;
        }
        handler.tick();
        hud.tick();

    }

    private void turn () {

    }

    private void render () {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(background, 0, 0, null);
        g.setColor(Color.green);
        g.fillRect(32,32, (int)(32*17.5), (int)(32*11.5));

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public void run () {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public static int clamp (int var, int min, int max) {
        if (var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
    }

    public static void main (String[] args) {
        new Game();
    }
}

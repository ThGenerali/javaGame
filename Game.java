package facul.java.javaGame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
   
    public static final int WIDTH = 640, HEIGHT= 480;

    public static int vida_terra = 100;

    public Spawner spawner;

    public Game() {
        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(dimension);
        spawner = new Spawner();
    }

    public void update() {
        spawner.update();
        if(vida_terra <= 0) {

        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
        g.setColor(Color.green);
        g.fillRect(Game.WIDTH/2 - 100 - 70, 20, vida_terra*3, 20);
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH/2 - 100 - 70, 20, 300, 20);
        spawner.render(g);
        bs.show();
    }

    public static void main (String[] args) {
        Game game = new Game();
        JFrame jframe = new JFrame("Save the world");
        jframe.add(game);
        jframe.setLocationRelativeTo(null);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setVisible(true);

        new Thread(game).start();
    }

    @Override
    public void run(){
        update();
        render();
        while(true){
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}

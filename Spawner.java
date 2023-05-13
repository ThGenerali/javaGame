package facul.java.javaGame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {

    public int timer = 0;

    public List<RectObj> meteoro = new ArrayList<RectObj>();

    public void update(){
        timer++;
        if(timer % 60 == 0) {
            meteoro.add(new RectObj(0, new Random().nextInt(480-40), 40, 40));
        }

        for(int i = 0; i < meteoro.size(); i++) {
            RectObj current = meteoro.get(i);

            meteoro.get(i).update();

            if(current.x > Game.WIDTH) {
                meteoro.remove(current);
                Game.vida_terra--;
            }
        }
    }

    public void render(Graphics g) {
        for(int i= 0; i < meteoro.size(); i++) {
            RectObj current = meteoro.get(i);
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(Math.toRadians(current.rotation), current.x + current.width/2, current.y + current.height/2);
            g2.setColor(current.color);
            g2.fillRect(current.x, current.y, current.width, current.height);
            g2.rotate(Math.toRadians(-current.rotation), current.x + current.width/2, current.y + current.height/2);
        }
    }

}
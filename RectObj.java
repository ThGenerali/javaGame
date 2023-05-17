package facul.java.javaGame;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class RectObj extends Rectangle {
    
    public Color color;

    public int speed = 0;

    public int rotation = 0;

    public RectObj(int x, int y, int width, int height) {
        super(x,y,width,height);

        color = new Color(150, 75, 0);

        speed = new Random().nextInt(6-2)+8;

    }

    public void update() {
        x += speed; 
        rotation+=4;
        if(rotation >= 360){
            rotation = 0;
        }
    }
}

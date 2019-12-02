import java.awt.*;
import java.awt.image.BufferedImage;

public class Animator {

    Graphics g;
    int prevX = 50;
    int prevY = 50;
    Graphics screenGraphics;
    BufferedImage img;

    public Animator(Graphics g) {
        this.screenGraphics = g;
        img = new BufferedImage(1200, 800, BufferedImage.TYPE_3BYTE_BGR);
        this.g = img.getGraphics();
        this.g.setColor(Color.WHITE);
        this.g.fillRect(0,0, 1200, 800);
    }

    public void drawOval(int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(prevX, prevY, 50, 50);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 50, 50);
        prevX = x;
        prevY = y;
    }

    public void draw2(){
        g.setColor(Color.BLACK);
        g.fillOval(200, 200, 100, 100);
        drawToScreen();
    }

    public void drawToScreen(){

        screenGraphics.drawImage(img, 0, 0, null);
    }
}

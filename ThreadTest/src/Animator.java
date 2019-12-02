import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Animator implements Runnable {

    ArrayList<Ball> balls = new ArrayList<>();

    Graphics g;
    int prevX = 50;
    int prevY = 50;
    private Graphics screenGraphics;
    BufferedImage img;

    Color c = Color.BLACK;

    public Animator(Graphics g) {
        this.screenGraphics = g;
        img = new BufferedImage(1200, 800, BufferedImage.TYPE_3BYTE_BGR);
        this.g = img.getGraphics();
        this.g.setColor(Color.WHITE);
        this.g.fillRect(0,0, 1200, 800);
    }

    public void addBall(Ball b){
        balls.add(b);
    }

    public void drawOval(int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(prevX, prevY, 50, 50);
        g.setColor(c);
        g.fillOval(x, y, 50, 50);
        prevX = x;
        prevY = y;
    }

    public void draw2(){
        Random r = new Random();
        c = new Color(r.nextInt(256),
                r.nextInt(256),
                r.nextInt(256));
    }

    public void drawToScreen(){
        screenGraphics.drawImage(img, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1200, 800);
            g.setColor(Color.BLACK);
            for (Ball b : balls) {
                g.fillOval(b.x, b.y, 50, 50);
                System.out.println(b.x + " | " + b.y);
            }
            drawToScreen();
        }
    }
}

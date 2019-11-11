import java.awt.*;
import java.util.Random;

public class Animator {

    Graphics2D graphics;

    int pressedX;
    int pressedY;

    public Animator(Graphics graphics) {
        this.graphics = (Graphics2D) graphics;
        this.graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );

    }

    public void drawSquare(int x, int y) {
        Random r = new Random();
        Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        graphics.setColor(c);
        graphics.fillRect(x, y, 50, 50);
//        graphics.drawLine();
    }

    public void drawLine(int x, int y) {

        graphics.drawLine(pressedX, pressedY, x, y);
    }
}

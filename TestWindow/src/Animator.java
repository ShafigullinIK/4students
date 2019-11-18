import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Animator {

    Graphics graphics;
    Graphics screenGraphics;

    final int CENTER_X = 600;
    final int CENTER_Y = 400;
    int CELL_SIZE = 100;
    int serifSize = 10;

    int currentX;
    int currentY;
    BufferedImage img;


    public Animator(Graphics graphics) {
        screenGraphics = graphics;
        img = new BufferedImage(1200, 800,
                BufferedImage.TYPE_3BYTE_BGR);
        this.graphics = img.getGraphics();
    }

    public void changeCellSize(int a) {
        resetImg();
        if (a > 0) {
            CELL_SIZE += 5;
        } else {
            if (CELL_SIZE > 7) {
                CELL_SIZE -= 5;
            }
        }
        drawAxis();
        drawToScreen();
    }

    public void drawSquare(int x, int y) {
        Random r = new Random();
        Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
        graphics.setColor(c);
        graphics.fillRect(x, y, 50, 50);
//        graphics.drawLine();
    }

    public void setXandY(int x, int y) {
        resetImg();
        currentX = x;
        currentY = y;
        double newX = coorTransX(x);
        double newY = coorTransY(y);
        graphics.fillOval(x - 5, y - 5, 10, 10);
        graphics.drawString("x = " + newX +
                "   y = " + newY, 800, 600);
        drawAxis();
        drawToScreen();
    }

    public void resetImg() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, img.getWidth(), img.getHeight());
        graphics.setColor(Color.BLACK);
    }

    public double coorTransX(int x) {
        double newX = (x - CENTER_X) * 1.0 / CELL_SIZE;
        return newX;
    }

    public double coorTransY(int y) {
        double newY = (CENTER_Y - y) * 1.0 / CELL_SIZE;
        return newY;
    }

    public void drawAxis() {
        drawX();
        drawY();
    }

    public void drawX() {
        graphics.drawLine(50, CENTER_Y,
                2 * CENTER_X - 50, CENTER_Y);
        graphics.drawLine(2 * CENTER_X - 80,
                CENTER_Y - 15, 2 * CENTER_X - 50, CENTER_Y);
        graphics.drawLine(2 * CENTER_X - 80, CENTER_Y + 15,
                2 * CENTER_X - 50, CENTER_Y);
        int countOfSerifs = (CENTER_X - 100) / CELL_SIZE;
        for (int i = 0; i < countOfSerifs; i++) {
            graphics.drawLine(CENTER_X + i * CELL_SIZE,
                    CENTER_Y - serifSize,
                    CENTER_X + i * CELL_SIZE,
                    CENTER_Y + serifSize);
            graphics.drawLine(CENTER_X - i * CELL_SIZE,
                    CENTER_Y - serifSize,
                    CENTER_X - i * CELL_SIZE, CENTER_Y + serifSize);
        }
    }

    public void drawY() {
        graphics.drawLine(600, 50, 600, 750);
        graphics.drawLine(585, 80, 600, 50);
        graphics.drawLine(615, 80, 600, 50);
        int countOfSerifs = (CENTER_Y - 100) / CELL_SIZE;
        for (int i = 0; i < countOfSerifs; i++) {
            graphics.drawLine(CENTER_X - serifSize, CENTER_Y + i * CELL_SIZE,
                    CENTER_X + serifSize, CENTER_Y + i * CELL_SIZE);
            graphics.drawLine(CENTER_X - serifSize, CENTER_Y - i * CELL_SIZE,
                    CENTER_X + serifSize, CENTER_Y - i * CELL_SIZE);
        }
    }

    public void drawToScreen() {
        screenGraphics.drawImage(img, 0, 0,
                img.getWidth(), img.getHeight(), null);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JFrame {

    public Window() {
        this.setBounds(100, 100, 1200, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1200, 800);
        panel.setBackground(Color.WHITE);
        this.add(panel);
        Animator animator = new Animator(panel.getGraphics());
        this.setVisible(true);

        int x = 100;
        int y = 100;
        int step = 10;
        for (int i = 0; i < 1_000; i++) {
            if(x > 50 && x < 1_000){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x += step;
                animator.drawOval(x, y);
                animator.drawToScreen();
            } else {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x -= step;
                step *= -1;
            }

        }

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animator.draw2();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}

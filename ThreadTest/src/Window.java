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
        new Thread(animator).start();
        this.setVisible(true);



        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Ball b = new Ball( e.getY());
                animator.addBall(b);
                new Thread(b).start();
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

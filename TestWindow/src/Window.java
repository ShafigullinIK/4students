import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Window extends JFrame {

    public Window(){

//        this.setSize(600, 400);
        this.setBounds(350,
                150, 1200, 800);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);

        Animator animator = new Animator(this.getGraphics());
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animator.setXandY(e.getX(), e.getY());
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

        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getWheelRotation());
                animator.changeCellSize(e.getWheelRotation());
            }
        });

        this.setVisible(true);

    }
}

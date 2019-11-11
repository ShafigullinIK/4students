import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Window extends JFrame {

    public Window(){

//        this.setSize(600, 400);
        this.setBounds(350,
                350, 600, 400);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
//        this.setResizable(false);
        this.setLayout(null);
        JButton button = new JButton();
        button.setBounds(this.getWidth()/2,
                this.getHeight()/2, 150, 75);
        button.setText("Кнопочка");
        this.add(button);
        JTextField tf = new JTextField();
        tf.setBounds(10, 10, 200, 50);
        this.add(tf);
        JTextField tf2 = new JTextField();
        tf2.setBounds(250, 10, 200, 50);
        this.add(tf2);
        this.setVisible(true);

        Animator animator = new Animator(this.getGraphics());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                animator.drawSquare(x,y);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                animator.pressedX = e.getX();
                animator.pressedY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                animator.drawLine(e.getX(), e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText(button.getText() + "!");

            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Random r = new Random();
                int newX = r.nextInt(400);
                int newY = r.nextInt(350);
                button.setBounds(newX, newY,
                        button.getWidth(), button.getHeight());
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.setVisible(true);

    }
}

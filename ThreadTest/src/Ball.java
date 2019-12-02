import java.awt.*;

public class Ball implements Runnable {

    Animator animator;
    int x = 100;
    int y;

    public Ball(int y){
        this.y = y;
    }

    @Override
    public void run() {
        int x = 100;
        int step = 10;
        for (int i = 0; i < 1_000; i++) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(x > 50 && x < 1_000){
                x += step;
            } else {
                x -= step;
                step *= -1;
            }
//            System.out.println("x = " + x + "y = " + y);
        }
    }
}

import controller.LagrangeController;
import controller.LagrangeController2;
import model.*;
import view.ConsoleView;
import view.FileView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//       ConsoleView consoleView = new ConsoleView();
//        LagrangeController lagrangeController = new LagrangeController(consoleView);
//        lagrangeController.start();
        LagrangeController2 controller = new LagrangeController2();
        FileView view = new FileView(controller);
        view.parseFile("source.txt");





    }
}

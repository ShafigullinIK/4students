package controller;

import model.Polynom;
import view.ConsoleView;

import java.io.IOException;

public class LagrangeController {
    private ConsoleView consoleView;

    public LagrangeController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void start() throws IOException {
        double[] x = consoleView.uzlyX();
        double[] y = consoleView.uzlyY();
        Polynom lagrange = createLagrange(x, y);
        consoleView.printResult(lagrange);
    }

    private Polynom createLagrange(double[] x, double[] y){
        Polynom[] l=new Polynom[x.length];
        for(int i=0;i<l.length;i++){
            l[i]=new Polynom(new double[]{1});
            for(int j=0;j<l.length;j++){
                if(i!=j){
                    l[i]=Polynom.mult(l[i], new Polynom(new double[]{-x[j],1}));
                    l[i]=Polynom.mult(l[i],1/(x[i]-x[j]));
                }

            }
        }
        Polynom result=new Polynom(new double[]{0});
        for(int i=0;i<x.length;i++){
            result=Polynom.sum(result,Polynom.mult(l[i],
                    new Polynom(new double[]{y[i]})));
        }
        return result;
    }
}

package view;

import model.Polynom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public double[] uzlyX() throws IOException {
        System.out.println("Vvedi uzly:");
        String s = reader.readLine();
        String[] temp = s.split(" ");
        double[] result= new double[temp.length];
        for(int i=0;i<result.length;i++){
            result[i]=Double.parseDouble(temp[i]);
        }
        return result;
    }

    public double[] uzlyY() throws IOException {
        System.out.println("Vvedi znacheniya:");
        String s = reader.readLine();
        String[] temp = s.split(" ");
        double[] result= new double[temp.length];
        for(int i=0;i<result.length;i++){
            result[i]=Double.parseDouble(temp[i]);
        }
        return result;
    }

    public void printResult(Polynom p) {
        System.out.println(p);
    }
}

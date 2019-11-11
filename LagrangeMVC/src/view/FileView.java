package view;

import controller.LagrangeController;
import controller.LagrangeController2;
import model.Polynom;

import java.io.*;

public class FileView {

    LagrangeController2 controller;

    public FileView(LagrangeController2 controller){
        this.controller = controller;
    }

    public void parseFile(String fileName){
        try(BufferedReader reader = new BufferedReader(
                new FileReader(fileName)
        )){
            while (reader.ready()){
                String stringX = reader.readLine();
                String stringY = reader.readLine();
                controller.setX(stringToDouble(stringX));
                controller.setY(stringToDouble(stringY));
                Polynom lagrange = controller.createLagrange();
                writeResultToFile(lagrange);
            }
        }catch (IOException e){

        }
    }

    private double[] stringToDouble(String s){
        String[] items = s.split(" ");
        double[] result = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = Double.parseDouble(items[i]);
        }
        return result;
    }

    public void writeResultToFile(Polynom p){
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter("result.txt", true)
        )){
            writer.write(p.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e){

        }
    }

}

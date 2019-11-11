package controller;

import model.Polynom;

public class LagrangeController2 {

    private double[] x;
    private double[] y;


    public void setX(double[] x){
        this.x = x;
    }

    public void setY(double[] y){
        this.y = y;
    }

    public Polynom createLagrange(){
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

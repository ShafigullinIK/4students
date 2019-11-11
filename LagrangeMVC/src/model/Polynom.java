package model;

public class Polynom {
    public double[] coef;

//    public Polynom(int len){
//        coef = new double[len];
//    }

    public Polynom(double[] coef) {
        this.coef = coef;
    }

    public int getlength() {
        return coef.length;
    }

    public static Polynom sum(Polynom a, Polynom b) {
        int alength;
        int blength;
        alength = a.getlength();
        blength = b.getlength();
        int clength;
        if (alength > blength) {
            clength = alength;
        } else clength = blength;
        double rez[] = new double[clength];
        for (int i = 0; i < alength; i++) {
            rez[i] += a.coef[i];
        }
        for (int i = 0; i < blength; i++) {
            rez[i] += b.coef[i];
        }

        Polynom c = new Polynom(rez);
        return c;

    }

    public static Polynom mult(Polynom a, Polynom b) {
        int rez = a.getlength() + b.getlength() - 1;
        double[] result = new double[rez];
        for (int i = 0; i < a.getlength(); i++) {
            for (int j = 0; j < b.getlength(); j++) {
                result[i + j] = result[i + j] + a.coef[i] * b.coef[j];
            }
        }
        return new Polynom(result);
    }

    private static double power(double point, int st) {
        double result = 1;
        for (int i = 0; i < st; i++) {
            result *= point;
        }
        return result;
    }

    public static double valueOnPoint(Polynom a, double point) {
        double result = 0;
        for (int i = 0; i < a.getlength(); i++) {
            result += a.coef[i]*power(point,i);
        }
        return result;
    }

    public static Polynom mult(Polynom polynom, double number) {
        double[] tempArray = new double[1];
        tempArray[0] = number;
        Polynom polynom1 = new Polynom(tempArray);
        return Polynom.mult(polynom, polynom1);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < coef.length; i++) {
            result = result + coef[i] + ",";
        }
        return result;
    }

}

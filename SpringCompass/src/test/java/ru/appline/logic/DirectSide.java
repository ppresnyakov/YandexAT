package ru.appline.logic;

import java.util.SplittableRandom;

public class  DirectSide {

    private int Degree1;
    private int Degree2;

    public  DirectSide(){
        super();
    }

    public DirectSide  (int Degree1, int Degree2) {
        this.Degree1 = Degree1;
        this.Degree2 = Degree2;
    }
// проверяет включается ли градус в данную сторону света
    public boolean  IsInclude (int Degree) {
        if (Degree1 > Degree2) {
             Degree2 += 360;
             Degree+=360;
        }
        if (Degree >= Degree1 && Degree <= Degree2 ) return  true;
        else return false;
    }

    public int getDegree1() {
        return Degree1;
    }

    public void setDegree1(int degree1) {
        Degree1 = degree1;
    }

    public int getDegree2() {
        return Degree2;
    }

    public void setDegree2(int degree2) {
        Degree2 = degree2;
    }

}

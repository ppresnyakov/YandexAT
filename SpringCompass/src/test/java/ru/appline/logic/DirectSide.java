package ru.appline.logic;

import java.util.SplittableRandom;

public class  DirectSide {

    private int Degree1;
    private int Degree2;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;

    public  DirectSide(){
        super();
    }

    public DirectSide  (int Degree1, int Degree2) {
        this.Degree1 = Degree1;
        this.Degree2 = Degree1;
    }
// проверяет включается ли градус в данную сторону света
    public boolean  IsInclude (int Degree) {
        if (Degree1 > Degree2) {
             Degree2 += 360;
        }
        if (Degree >= Degree1 && Degree <= Degree2 ) return  true;
        else return false;
    }
}

package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CompassModel implements Serializable {
    public static final CompassModel instance = new CompassModel();
    public static Map <String, DirectSide> Model ;
    // иницализурем стандартные значения 8 сторон света и делаем мапу из сторон
    DirectSide North = new DirectSide( 350, 10);
    DirectSide NorthEast = new DirectSide( 11, 79);
    DirectSide East = new DirectSide( 80, 100);
    DirectSide EastSouth = new DirectSide( 101, 169);
    DirectSide South = new DirectSide(170, 190);
    DirectSide SouthWest = new DirectSide( 191, 259);
    DirectSide West = new DirectSide( 260,280 );
    DirectSide WestNorth = new DirectSide( 281, 349);


    public CompassModel(){
        Model = new HashMap<String, DirectSide>();
        Model.put("Север", North);
        Model.put("Северо-восток", NorthEast);
        Model.put("Восток", East);
        Model.put("Юго-Восток", EastSouth);
        Model.put("Юг", South);
        Model.put("Юго-запад", SouthWest);
        Model.put("Запад", West);
        Model.put("Северо-Запад", WestNorth);
    }

    public static Map<String, DirectSide> getInstance(){
        return Model;
    }
    public static Map<String, DirectSide> getAll(){
        return  Model;
    }



}


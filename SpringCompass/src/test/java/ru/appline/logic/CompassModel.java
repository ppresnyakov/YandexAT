package ru.appline.logic;

import java.io.Serializable;
import java.util.Map;

public class CompassModel implements Serializable {
    private static final CompassModel instance = new CompassModel();
    private static Map <String, DirectSide> CompassModel ;
    // иницализурем стандартные значения 8 сторон света и делаем мапу из сторон
    public CompassModel(){
        DirectSide North = new DirectSide( 350, 10);
        DirectSide NorthEast = new DirectSide( 11, 79);
        DirectSide East = new DirectSide( 80, 100);
        DirectSide EastSouth = new DirectSide( 101, 169);
        DirectSide South = new DirectSide(170, 190);
        DirectSide SouthWest = new DirectSide( 191, 259);
        DirectSide West = new DirectSide( 260,280 );
        DirectSide WestNorth = new DirectSide( 281, 349);

        CompassModel.put("Север", North);
        CompassModel.put("Северо-восток", NorthEast);
        CompassModel.put("Восток", East);
        CompassModel.put("Юго-Восток", EastSouth);
        CompassModel.put("Юг", South);
        CompassModel.put("Юго-запад", SouthWest);
        CompassModel.put("Запад", West);
        CompassModel.put("Северо-Запад", WestNorth);
    }


    public static CompassModel getInstance(){
        return instance;
    }
    public static Map<String, DirectSide> getAll(){
        return  CompassModel;
    }


    public static String getDirectFromDegree(int Degree){
            String NameOfDirect = null;
        for (Map.Entry<String, DirectSide> entry : CompassModel.entrySet()) {
             if  (entry.getValue().IsInclude(Degree)){ NameOfDirect =  entry.getValue().getName() ;}

        }
        if (NameOfDirect == null) {return "Что-то пошло не так"; }
        else return NameOfDirect;
    }

    public static void setCompassModel(Map<String, DirectSide> compassModel) {
        CompassModel = compassModel;
    }
}


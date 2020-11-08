package ru.appline.controller;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.CompassModel;
import ru.appline.logic.DirectSide;

import  java.util.Map;


@RestController
public class Controller {
    private static Map<String, DirectSide> Model= CompassModel.getInstance();


    @GetMapping (value = "/FindDirect", consumes = "application/json", produces = "application/text")
    public static String getDirectFromDegree( @RequestBody Map<String, Integer> Degree){
        String NameOfDirect = null;
        for (Map.Entry<String, DirectSide> entry : Model.entrySet()) {
            if  (entry.getValue().IsInclude(Degree.get("Degree"))){ NameOfDirect =  entry.getKey() ;}
        }
        if (NameOfDirect == null) {return "Что-то пошло не так"; }
        else return  NameOfDirect;
    }
    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<String, DirectSide> getAll() {
        return CompassModel.getAll();
    }

    @PutMapping (value = "/PutNewCompass", consumes = "application/json", produces = "application/json")
    public Map<String, DirectSide> PutNewCompass(@RequestBody Map<String, String> NewCompass)
    {
        String msg = null;
        for (Map.Entry<String, String > entry : NewCompass.entrySet()) {
            String DegreeArray[] = entry.getValue().split("-");
            if (DegreeArray.length == 2)
            {
            int Degree1 = Integer.parseInt( DegreeArray[0]);
            int Degree2 = Integer.parseInt( DegreeArray[1]);
            DirectSide tmpSide = new DirectSide(Degree1, Degree2 );
            switch (entry.getKey()){
                case"Север": Model.put("Север", tmpSide  ); break;
                case "Северо-восток": Model.put("Северо-восток", tmpSide  ) ; break;
                case"Восток": Model.put("Восток", tmpSide  ) ; break;
                case"Юго-Восток": Model.put("Юго-Восток", tmpSide  ) ; break;
                case"Юг": Model.put("Юг", tmpSide  ) ; break;
                case"Юго-запад": Model.put("Юго-запад", tmpSide  ) ; break;
                case"Запад": Model.put("Запад", tmpSide  ) ; break;
                case"Северо-Запад": Model.put("Северо-Запад", tmpSide  ) ; break;
                default:  msg = "Что то пошло не так";}
            }  else msg = "У вас в одном и направлений количество углов не равно двум!";
    }
        return CompassModel.getAll();
}}












package ru.appline.controller;
import org.springframework.web.bind.annotation.*;
import ru.appline.logic.CompassModel;
import ru.appline.logic.DirectSide;
import  java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {
    private static final CompassModel compassModel = CompassModel.getInstance();

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<String, DirectSide> getAll() {
        return CompassModel.getAll();
    }


}










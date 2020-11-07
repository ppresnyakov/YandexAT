package ru.appline.controller;


import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;
import  java.util.Map;

import java.util.concurrent.atomic.AtomicInteger;

@RestController

public class Controller {
    private static final PetModel petmodel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/text")
    public static String createPet(@RequestBody Pet pet) {
        PetModel.add(pet, newId.getAndDecrement());
        return "Питомец " + pet.getName() + " был успешно создан";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
      return PetModel.getAll();
    }

    @GetMapping (value = "/getPet", consumes = "application/json", produces = "application/json")
            public Pet getPet(@RequestBody Map<String, Integer> id)
    {
        return petmodel.getFromlist(id.get("id"));
    }


    @PutMapping (value = "/putPet", consumes = "application/json", produces = "application/text")
    public String putPet(@RequestBody Map<String, String> PutPetRequest )
    {
        String tmpName = PetModel.getFromlist(Integer.parseInt(PutPetRequest.get("id"))).getName() ;
        Pet NewPet = new Pet( PutPetRequest.get("name"),  PutPetRequest.get("type"), Integer.parseInt(PutPetRequest.get("age")));
        PetModel.put(Integer.parseInt(PutPetRequest.get("id")),  NewPet);
        return "Питомец " + tmpName + " был заменён на " + NewPet.getName();
    }
    @DeleteMapping (value = "/deletePet", consumes = "application/json", produces = "application/text")
    public String deletePet(@RequestBody Map<String, Integer> id)
    {   String TmpName = PetModel.getFromlist(id.get("id")).getName();
        PetModel.deletePet(id.get("id"));
        return "Питомец " + TmpName + " был удалён.";
    }
}










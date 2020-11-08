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
        petmodel.add(pet, newId.getAndDecrement());
        return "Питомец " + pet.getName() + " был успешно создан";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
      return petmodel.getAll();
    }

    @GetMapping (value = "/getPet", consumes = "application/text", produces = "application/json")
            public Pet getPet(@RequestBody  String id)
    {
        return petmodel.getFromlist(Integer.parseInt(id));
    }


    @PutMapping (value = "/putPet", consumes = "application/json", produces = "application/text")
    public String putPet(@RequestBody Map<String, String> PutPetRequest )
    {
        String tmpName = PetModel.getFromlist(Integer.parseInt(PutPetRequest.get("id"))).getName() ;
        Pet NewPet = new Pet( PutPetRequest.get("name"),  PutPetRequest.get("type"), Integer.parseInt(PutPetRequest.get("age")));
        PetModel.put(Integer.parseInt(PutPetRequest.get("id")),  NewPet);
        return "Питомец " + tmpName + " был заменён на " + NewPet.getName();
    }
    @DeleteMapping (value = "/deletePet", consumes = "application/text", produces = "application/text")
    public String deletePet(@RequestBody String  id)
    {   String TmpName = PetModel.getFromlist(Integer.parseInt(id)).getName();
        PetModel.deletePet(Integer.parseInt(id));
        return "Питомец " + TmpName + " был удалён.";
    }
}










package ru.appline.logic;

import org.springframework.web.bind.annotation.GetMapping;

import javax.management.openmbean.TabularData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private static Map <Integer, Pet> model ;

    public PetModel(){
        model = new HashMap<Integer, Pet>();
    }
    public static PetModel getInstance(){
        return instance;
    }
    public  static void  add(Pet pet, int id){
        model.put(id,pet);
    }
    public  static void  put( int id, Pet pet){
        model.replace(id,pet);
    }
    public static Pet getFromlist(int id){
        return model.get(id);
    }
    public static Map<Integer, Pet> getAll(){
        return model;
    }
    public  static void  delete( int id){ model.remove(id);}

}


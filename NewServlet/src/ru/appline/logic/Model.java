package ru.appline.logic;
import javax.xml.namespace.QName;
import  java.io.Serializable;
import  java.util.HashMap;
import  java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();

    private final Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();

        model.put(1, new User("Pavel", "Presnyakov", 777));
        model.put(2, new User("Nick", "Wak", 555));
        model.put(3, new User("Angel", "Devastator", 666));


    }

    public void add(User user, int id){
        model.put(id,user);
    }
    public void del(int id){ model.remove(id);}
    public void put(int id, User user) {
        model.replace(id, user);
    }

    public Map <Integer, User> getFromList() {
        return model;
    }
}

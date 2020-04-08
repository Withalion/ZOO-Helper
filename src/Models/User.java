package Models;

import AnimalPavilons.AnimalPavilon;
import Controllers.LoginController;

import java.io.Serializable;

public class User implements Serializable, Entry {
    private Integer ID;
    private String Name;
    public transient LoginController loginController;

    public void setID(Integer uID){
        this.ID = uID;
    }
    public Integer getID(){
        return this.ID;
    }
    public void setName(String uName){
        this.Name = uName;
    }
    public String getName(){
        return this.Name;
    }
    public void polyLogin(){

    }
    public void LogIn(){
        this.loginController = LoginController.getInstance();
        this.polyLogin();
        return;
    }

    @Override
    public boolean TryEnter(AnimalPavilon entrySpace) {
        System.out.println("Cannot Entry");
        return false;
    }
}

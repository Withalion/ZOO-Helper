package Models;

import java.io.Serializable;

public class User implements Serializable {
    private Integer ID;
    private String Name;

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
    public void LogIn(){

    }
}

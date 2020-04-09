package Models;

public class Manazer extends Zamestnanec {

    public Manazer (Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }
    public void polyLogin(){
        this.loginController.ManagerOV();
    }
}

package Models;

public class Pokladnik extends Zamestnanec {

    public Pokladnik (Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }
    public void polyLogin(){
        this.loginController.CashierOV();
    }
}

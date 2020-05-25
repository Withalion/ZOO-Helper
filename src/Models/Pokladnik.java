package Models;

public class Pokladnik extends Employee {

    public Pokladnik (Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }

    /**
     * Metóda, ktorá vyvolá vytvorenie okna pre pokladníka.
     */
    public void polyLogin(){
        this.loginController.CashierOV();
    }
}

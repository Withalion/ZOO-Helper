package Models;

public class Manager extends Employee {

    public Manager(Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }

    /**
     * Metóda, ktorá vyvolá vytvorenie okna pre manažéra.
     */
    public void polyLogin(){
        this.loginController.ManagerOV();
    }
}

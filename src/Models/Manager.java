package Models;

public class Manager extends Employee {

    public Manager(Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }
    public void polyLogin(){
        this.loginController.ManagerOV();
    }
}

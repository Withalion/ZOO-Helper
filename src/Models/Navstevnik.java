package Models;

public class Navstevnik extends User implements Entry{

    public void polyLogin(){
        this.loginController.VisitorOV();
    }
}

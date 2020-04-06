package Controllers;

import Models.Navstevnik;
import View.NavstevnikView;

public class NavstevnikController {
    private static NavstevnikController instance = null;
    private NavstevnikView visitorView =null;
    private NavstevnikController(){

    }
    public static NavstevnikController getInstance(){
        if (instance == null)instance = new NavstevnikController();
        return instance;
    }
    public void PairVController(NavstevnikView vView){
        this.visitorView = vView;
    }
}

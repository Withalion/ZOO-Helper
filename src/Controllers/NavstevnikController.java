package Controllers;

import AnimalPavilons.AnimalPavilon;
import Models.Navstevnik;
import View.NavstevnikView;

public class NavstevnikController {
    private static NavstevnikController instance = null;
    private LoginController lgInstance = LoginController.getInstance();
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
    public void TryEnter(AnimalPavilon entrySpace){
        if (lgInstance.pickedUser.TryEnter(entrySpace)) visitorView.openDoor();
        else visitorView.lockDoor();
    }
}

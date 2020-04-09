package Controllers;

import AnimalPavilons.AnimalPavilon;
import View.AniHandlerView;
import View.CashierView;
import View.ManagerView;

public class ZamestnanecController {
    private static Controllers.ZamestnanecController instance = null;
    private AniHandlerView handlerView =null;
    private ManagerView managerView =null;
    private CashierView cashierView =null;
    private LoginController lgInstance = LoginController.getInstance();
    private ZamestnanecController(AniHandlerView view){
        this.handlerView = view;
    }
    private ZamestnanecController(ManagerView view){
        this.managerView = view;
    }
    private ZamestnanecController(CashierView view){
        this.cashierView = view;
    }
    public static Controllers.ZamestnanecController getInstance(AniHandlerView view){
        if (instance == null)instance = new Controllers.ZamestnanecController(view);
        return instance;
    }
    public static Controllers.ZamestnanecController getInstance(ManagerView view){
        if (instance == null)instance = new Controllers.ZamestnanecController(view);
        return instance;
    }
    public static Controllers.ZamestnanecController getInstance(CashierView view){
        if (instance == null)instance = new Controllers.ZamestnanecController(view);
        return instance;
    }
    public static Controllers.ZamestnanecController getInstance(){
        return instance;
    }
    public void PairEController(AniHandlerView eView){
        this.handlerView = eView;
    }
    public void PairEController(ManagerView eView){
        this.managerView = eView;
    }
    public void PairEController(CashierView eView){
        this.cashierView = eView;
    }
    public void TryEnter(AnimalPavilon entrySpace){
        if (lgInstance.pickedUser.TryEnter(entrySpace)) handlerView.openDoor();
        else handlerView.lockDoor();
    }
    public void FeedAnimals(){
        lgInstance.pickedUser.FeedME();
    }
    public void FeedUpdate(String text){
        handlerView.FeedStatus.appendText(text);
    }
}


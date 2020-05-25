package Controllers;

import AnimalPavilons.AnimalPavilon;
import View.VisitorView;

/**
 * Controller k oknu návštevníka.
 */
public class VisitorController {
    private static VisitorController instance = null;
    private LoginController lgInstance = LoginController.getInstance();
    private VisitorView visitorView =null;
    private VisitorController(){

    }
    public static VisitorController getInstance(){
        if (instance == null)instance = new VisitorController();
        return instance;
    }
    public void PairVController(VisitorView vView){
        this.visitorView = vView;
    }

    /**
     * Metóda, ktorá vyvolá pokus o vstup.
     * @param entrySpace vybraný pavilón
     */
    public void TryEnter(AnimalPavilon entrySpace){
        if (lgInstance.pickedUser.TryEnter(entrySpace)) visitorView.openDoor();
        else visitorView.lockDoor();
    }
}

package Models;

import AnimalPavilons.*;
import Controllers.NavstevnikController;

public class Navstevnik extends User{
    private transient NavstevnikController NCinstance = NavstevnikController.getInstance();
    public void polyLogin(){
        this.loginController.VisitorOV();
    }

    @Override
    public void TryEnter(AnimalPavilon entrySpace) {
        ButterflyGarden helpGarden = new ButterflyGarden(null);
        if (entrySpace == null || helpGarden.getClass() != entrySpace.getClass()) NCinstance.EntranceClosed();
        else NCinstance.EntranceOpen();
        helpGarden = null;
    }
}

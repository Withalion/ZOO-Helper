package Models;

import AnimalPavilons.*;
import Controllers.NavstevnikController;

public class Navstevnik extends User{
    int MoneySpent;
    private transient NavstevnikController NCinstance = NavstevnikController.getInstance();
    public void polyLogin(){
        this.loginController.VisitorOV();
    }

    @Override
    public boolean TryEnter(AnimalPavilon entrySpace) {
        ButterflyGarden helpGarden = new ButterflyGarden(null);
        if (entrySpace == null || helpGarden.getClass() != entrySpace.getClass()) {
            helpGarden = null;
            return false;
        }
        else {
            helpGarden = null;
            return true;
        }
    }
}

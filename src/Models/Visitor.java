package Models;

import AnimalPavilons.*;
import Controllers.VisitorController;

public class Visitor extends User{
    int MoneySpent;
    private transient VisitorController NCinstance = VisitorController.getInstance();

    /**
     * Metóda otvorí pre všetkých návštevníkov rovnaké okno.
     */
    public void polyLogin(){
        this.loginController.VisitorOV();
    }

    /**
     * Metóda, ktorá dovoluje návštevníkom vstúpiť iba do motýlej záhrady.
     * @param entrySpace pavilon do ktoreho chcu vstupit
     * @return true/false
     */
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

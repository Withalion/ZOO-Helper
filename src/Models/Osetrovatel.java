package Models;

import AnimalPavilons.AnimalPavilon;
import Animals.Animal;
import Controllers.ZamestnanecController;

import java.util.ArrayList;

public class Osetrovatel extends Zamestnanec implements Feedable, Showable{
    private ArrayList<Animal> animals = new ArrayList<>();
    private transient ZamestnanecController ZCinstance = ZamestnanecController.getInstance();
    private boolean Amphibian;
    private boolean Bird;
    private boolean Cat;
    private boolean Fish;
    private boolean Invertebrate;
    private boolean Mammal;
    private boolean Primate;
    private boolean Reptile;

    public Osetrovatel (int uID, String uName, boolean oAmphibian, boolean oBird, boolean oCat, boolean oFish, boolean oInvertebrate, boolean oMammal, boolean oPrimate, boolean oReptile){
        this.setID(uID);
        this.setName(uName);
        this.setAmphibian(oAmphibian);
        this.setBird(oBird);
        this.setCat(oCat);
        this.setFish(oFish);
        this.setInvertebrate(oInvertebrate);
        this.setMammal(oMammal);
        this.setPrimate(oPrimate);
        this.setReptile(oReptile);
    }

    @Override
    public void TryEnter(AnimalPavilon entrySpace) {
        if (entrySpace == null ) ZCinstance.EntranceClosed();
        else{
            switch(entrySpace.getClass().getSimpleName()){
                
            }
        }
    }

    public ArrayList getArraylist(){
        return animals;
    }
    public void setAmphibian(boolean amphibian) {
        Amphibian = amphibian;
    }
    public boolean isAmphibian() {
        return Amphibian;
    }
    public void setBird(boolean bird){
        Bird = bird;
    }
    public boolean isBird() {
        return Bird;
    }
    public void setCat(boolean cat) {
        Cat = cat;
    }
    public boolean isCat() {
        return Cat;
    }
    public void setFish(boolean fish){
        Fish = fish;
    }
    public boolean isFish() {
        return Fish;
    }
    public void setInvertebrate(boolean invertebrate) {
        Invertebrate = invertebrate;
    }
    public boolean isInvertebrate() {
        return Invertebrate;
    }
    public void setMammal(boolean mammal) {
        Mammal = mammal;
    }
    public boolean isMammal() {
        return Mammal;
    }
    public void setPrimate(boolean primate) {
        Primate = primate;
    }
    public boolean isPrimate() {
        return Primate;
    }
    public void setReptile(boolean reptile){
        Reptile = reptile;
    }
    public boolean isReptile() {
        return Reptile;
    }
}

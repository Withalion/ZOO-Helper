package Models;

public class Osetrovatel extends Zamestnanec implements Entry, Feedable, Showable{

    public Osetrovatel (Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }
}

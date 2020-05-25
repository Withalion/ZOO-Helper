package Models;

import Help.Strategy;
import Help.UserDB;

/**
 * Trieda pre dospelého návštevníka, vytvára sa pomocou VisitorMakera.
 */
public class Adult extends Visitor implements Strategy {

    public Adult(Integer uID, String uName){
        this.setID(uID);
        this.setName(uName);
    }

    public Adult() {

    }

    /**
     * Metóda, ktorá vytvorenému objektu priradí všetky údaje.
     * ID je náhodne generované a zároveň nemôže byť použité.
     * @param Name meno návštevníka
     */
    public void WriteUserDetails(String Name){
        int NewID = 0;
        System.out.print(this.getClass()+"\n");
        this.setName(Name);
        System.out.print(this.getName()+"\n");
        int success = 0;
        while (success != UserDB.users.size()) {
            success = 0;
            NewID = (int) ((Math.random() * ((50000 - 10000) + 1)) + 10000);
            for (User CurrentUser : UserDB.users) {
                if (CurrentUser.getID() == NewID) break;
                else success++;
            }
        }
        this.setID(NewID);
        //System.out.println(this.getID());
    }
}

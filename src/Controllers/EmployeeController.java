package Controllers;

import AnimalPavilons.AnimalPavilon;
import Animals.Animal;
import Help.AnimalDB;
import Help.NameException;
import Help.UserDB;
import Help.VisitorMaker;
import Models.*;
import View.AniHandlerView;
import View.CashierView;
import View.ManagerView;

import java.util.ArrayList;

/**
 * Controller pre Zamestnanecké okná sprostredkuje požiadavky používateľa modelom a rieši logiku.
 */
public class EmployeeController {
    private static EmployeeController instance = null;
    private AniHandlerView handlerView =null;
    private ManagerView managerView =null;
    private CashierView cashierView =null;
    private LoginController lgInstance = LoginController.getInstance();
    private Help.VisitorMaker VisitorMaker = new VisitorMaker();
    public ArrayList<User> StaffDB = new ArrayList<>();

    /**
     * Priradí okno ošetrovateľa ku controlleru.
     * @param view otvorené okno
     */
    private EmployeeController(AniHandlerView view){
        this.handlerView = view;
    }

    /**
     * Priradí okno manažera ku controlleru.
     * @param view otvorené okno
     */
    private EmployeeController(ManagerView view){
        this.managerView = view;
    }

    /**
     * Priradí okno pokladníka ku controlleru.
     * @param view otvorené okno
     */
    private EmployeeController(CashierView view){
        this.cashierView = view;
    }

    public static EmployeeController getInstance(AniHandlerView view){
        if (instance == null)instance = new EmployeeController(view);
        return instance;
    }
    public static EmployeeController getInstance(ManagerView view){
        if (instance == null)instance = new EmployeeController(view);
        return instance;
    }
    public static EmployeeController getInstance(CashierView view){
        if (instance == null)instance = new EmployeeController(view);
        return instance;
    }
    public static EmployeeController getInstance(){
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

    /**
     * Metóda ktorá rieši vstup do pavilónu.
     * @param entrySpace pavilón do ktorého chce vstúpiť
     */
    public void TryEnter(AnimalPavilon entrySpace){
        if (lgInstance.pickedUser.TryEnter(entrySpace)) handlerView.openDoor();
        else handlerView.lockDoor();
    }

    /**
     * Metóda, ktorá vyvolá metódu o ošetrovateľa na krmenie zvierat a následne uloží databázu zvierat.
     */
    public void FeedAnimals(){
        this.FeedUpdate(lgInstance.pickedUser.FeedME());
        AnimalDB ActiveAnimalDB = new AnimalDB();
        ActiveAnimalDB.start();
    }
    public void FeedUpdate(String text){
        handlerView.FeedStatus.appendText(text);
    }

    /**
     * Metóda, ktorá vytvorí Arraylist zamestnancov z používateľov.
     */
    public void CreateStaffDB(){
       for (User user:UserDB.users){
           if (user instanceof Employee){
               StaffDB.add(user);
           }
       }
    }

    /**
     * Metóda, ktorá ukáže aktuálne údaje zamestnanca + pri ošetrovateľoch aj pridelené zvieratá.
     * @param staff vybraný zamestnanec
     */
    public void updateDetails(User staff){
       // managerView.salaryTXT.setText(staff.getSalary().toString());      WIP
        managerView.idTXT.setText(staff.getID().toString());
        managerView.nameTXT.setText(staff.getName());
        if (staff instanceof Zookeeper){
            managerView.Animals.setVisible(true);
            managerView.Animals.clear();
            managerView.Animals.appendText("Taking care of: \n");
            for (Animal animal:((Zookeeper) staff).animals){
                managerView.Animals.appendText("Name: "+animal.Name+"\nType of animal: "+animal.getClass().getSimpleName()+"\n");
            }
            managerView.animalADD.setVisible(true);
            managerView.animalChoice.setVisible(true);
        }
        else {
            managerView.Animals.setVisible(false);
            managerView.animalADD.setVisible(false);
            managerView.animalChoice.setVisible(false);
        }
    }

    /**
     * Uloženie údajov zamestnancov po zmene.
     * @param staff vybraný zamestnanec
     */
    public void saveDATA(User staff){
        staff.setID(Integer.valueOf(managerView.idTXT.getText()));
        staff.setName(managerView.nameTXT.getText());
       // staff.setSalary(Integer.valueOf(managerView.salaryTXT.getText()));        WIP
        UserDB ActiveUserDB = new UserDB();
        ActiveUserDB.start();
    }

    /**
     * Metóda, ktorá priraďuje zvieratá zamestnancov podľa toho čo zvolil používateľ.
     * @param pickedAnimal vybrané zviera
     * @param pickedCare zvolený ošetrovateľ
     */
    public void AddAnimal(Animal pickedAnimal, User pickedCare){
        for (Animal animal:((Zookeeper)pickedCare).animals){      //neriesi specializaciu osetrovatelov
            if (animal.equals(pickedAnimal)){
                managerView.goodANI.setVisible(false);
                managerView.wrongANI.setVisible(true);
                return;
            }
        }
        ((Zookeeper) pickedCare).animals.add(pickedAnimal);
        managerView.wrongANI.setVisible(false);
        managerView.goodANI.setVisible(true);
        this.updateDetails(pickedCare);
    }

    /**
     * Metóda, ktorá vytvorí nového návštevníka na základe požiadavky pokladníka, pomocou strategy.
     * @param VisitorType typ návštevníka
     * @param Name meno návštevníka
     * @see NameException
     */
    public void sellTicket(String VisitorType, String Name){
        try {
            if (Name.equals("")) throw new NameException("Enter visitor's name!");
            for (int i=0; i<Name.length(); i++){
                if (Character.isDigit(Name.charAt(i))) throw new NameException("Name contains number!");
            }
            switch (VisitorType) {
                case "Child":
                    VisitorMaker.SetStrategy(new Child());
                    break;
                case "Adult":
                    VisitorMaker.SetStrategy(new Adult());
                    break;
                case "Senior":
                    VisitorMaker.SetStrategy(new Senior());
                    break;
            }
            VisitorMaker.MakeVisitor(Name);
            cashierView.GoodCreate.setVisible(true);
        } catch (NameException e) {
            System.out.print(e.getMessage());
            cashierView.BadCreate.setVisible(true);
        }
    }
}


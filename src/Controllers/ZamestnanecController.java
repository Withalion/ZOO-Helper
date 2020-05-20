package Controllers;

import AnimalPavilons.AnimalPavilon;
import Animals.Animal;
import Help.AnimalDB;
import Help.UserDB;
import Models.*;
import View.AniHandlerView;
import View.CashierView;
import View.ManagerView;

import java.util.ArrayList;

public class ZamestnanecController {
    private static Controllers.ZamestnanecController instance = null;
    private AniHandlerView handlerView =null;
    private ManagerView managerView =null;
    private CashierView cashierView =null;
    private LoginController lgInstance = LoginController.getInstance();
    private VisitorMaker VisitorMaker = new VisitorMaker();
    public ArrayList<User> StaffDB = new ArrayList<>();
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
       this.FeedUpdate(lgInstance.pickedUser.FeedME());
        AnimalDB.saveDB();
    }
    public void FeedUpdate(String text){
        handlerView.FeedStatus.appendText(text);
    }
    public void CreateStaffDB(){
       for (User user:UserDB.users){
           if (user instanceof Zamestnanec){
               StaffDB.add(user);
           }
       }
    }
    public void updateDetails(User staff){
       // managerView.salaryTXT.setText(staff.getSalary().toString());      WIP
        managerView.idTXT.setText(staff.getID().toString());
        managerView.nameTXT.setText(staff.getName());
        if (staff instanceof Osetrovatel){
            managerView.Animals.setVisible(true);
            managerView.Animals.clear();
            managerView.Animals.appendText("Taking care of: \n");
            for (Animal animal:((Osetrovatel) staff).animals){
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
    public void saveDATA(User staff){
        staff.setID(Integer.valueOf(managerView.idTXT.getText()));
        staff.setName(managerView.nameTXT.getText());
       // staff.setSalary(Integer.valueOf(managerView.salaryTXT.getText()));        WIP
        UserDB.saveDB();
    }
    public void AddAnimal(Animal pickedAnimal, User pickedCare){
        for (Animal animal:((Osetrovatel)pickedCare).animals){      //neriesi specializaciu osetrovatelov
            if (animal.equals(pickedAnimal)){
                managerView.goodANI.setVisible(false);
                managerView.wrongANI.setVisible(true);
                return;
            }
        }
        ((Osetrovatel) pickedCare).animals.add(pickedAnimal);
        managerView.wrongANI.setVisible(false);
        managerView.goodANI.setVisible(true);
        this.updateDetails(pickedCare);
    }
    public void sellTicket(String VisitorType, String Name){
        switch (VisitorType){
            case "Child" : VisitorMaker.SetStrategy(new Dieta());
            break;
            case "Adult" : VisitorMaker.SetStrategy(new Dospeli());
            break;
            case "Senior" : VisitorMaker.SetStrategy(new Senior());
            break;
        }
        VisitorMaker.MakeVisitor(Name);
    }
}


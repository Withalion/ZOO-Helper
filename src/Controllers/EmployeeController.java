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

public class EmployeeController {
    private static EmployeeController instance = null;
    private AniHandlerView handlerView =null;
    private ManagerView managerView =null;
    private CashierView cashierView =null;
    private LoginController lgInstance = LoginController.getInstance();
    private Help.VisitorMaker VisitorMaker = new VisitorMaker();
    public ArrayList<User> StaffDB = new ArrayList<>();
    private EmployeeController(AniHandlerView view){
        this.handlerView = view;
    }
    private EmployeeController(ManagerView view){
        this.managerView = view;
    }
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
    public void TryEnter(AnimalPavilon entrySpace){
        if (lgInstance.pickedUser.TryEnter(entrySpace)) handlerView.openDoor();
        else handlerView.lockDoor();
    }
    public void FeedAnimals(){
        this.FeedUpdate(lgInstance.pickedUser.FeedME());
        AnimalDB ActiveAnimalDB = new AnimalDB();
        ActiveAnimalDB.start();
    }
    public void FeedUpdate(String text){
        handlerView.FeedStatus.appendText(text);
    }
    public void CreateStaffDB(){
       for (User user:UserDB.users){
           if (user instanceof Employee){
               StaffDB.add(user);
           }
       }
    }
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
    public void saveDATA(User staff){
        staff.setID(Integer.valueOf(managerView.idTXT.getText()));
        staff.setName(managerView.nameTXT.getText());
       // staff.setSalary(Integer.valueOf(managerView.salaryTXT.getText()));        WIP
        UserDB ActiveUserDB = new UserDB();
        ActiveUserDB.start();
    }
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

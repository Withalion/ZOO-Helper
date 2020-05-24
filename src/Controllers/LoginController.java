package Controllers;

import View.NavstevnikView;
import View.*;
import Models.User;
import Help.*;
import javafx.stage.Stage;


public class LoginController {
    public static int budget = 0;
    public LoginView loginView = null;
    private static LoginController instance = null;
    public User pickedUser = null;
    private LoginController(){
    }

    public static LoginController getInstance(){
        if (instance == null)instance = new LoginController();
        return instance;
    }
    public void PairController(LoginView lgView){
        this.loginView = lgView;
    }
    public void loadUsers(){
        UserDB ActiveUserDB = new UserDB();
        ActiveUserDB.start();
    }
    public void loadAnimals(){
        AnimalDB ActiveAnimalDB = new AnimalDB();
        ActiveAnimalDB.start();
    }
    public void loadPavilons(){
        PavilonDB ActivePavilonDB = new PavilonDB();
        ActivePavilonDB.start();
    }
    public void loginUser(String userID){
       for (int i = 0; i <UserDB.users.size(); i++){
           try {                                             //exception ak by zadane ID bola blbost
               if (UserDB.users.get(i).getID().equals(Integer.parseInt(userID))) {
                   pickedUser = UserDB.users.get(i);
                   loginView.goodLogin(pickedUser.getName());
                   pickedUser.LogIn();
                   return;
               }
           } catch (NumberFormatException e) {
               break;
           }
       }
       loginView.badLogin();
    }
    public User getPickedUser(){return this.pickedUser;}
    public void VisitorOV(){
        new NavstevnikView().start(new Stage());
    }
    public void HandlerOV(){
        new AniHandlerView().start(new Stage());
    }
    public void ManagerOV(){
        new ManagerView().start(new Stage());
    }
    public void CashierOV(){
        new CashierView().start(new Stage());
    }
    public void logoutUser(){
        UserDB ActiveUserDB = new UserDB();
        ActiveUserDB.start();
        AnimalDB ActiveAnimalDB = new AnimalDB();
        ActiveAnimalDB.start();
        PavilonDB ActivePavilonDB = new PavilonDB();
        ActivePavilonDB.start();
        this.loginView.logout();
    }
}

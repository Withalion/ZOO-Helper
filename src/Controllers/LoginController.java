package Controllers;

import View.VisitorView;
import View.*;
import Models.User;
import Help.*;
import javafx.stage.Stage;

/**
 * Controller spracujúci všetkú logiku za Login oknom, ktoré vidí používateľ.
 * Vytvorené a spárované s Login oknom.
 */
public class LoginController {
    public static int budget = 0;
    public LoginView loginView = null;
    private static LoginController instance = null;
    public User pickedUser = null;
    private LoginController(){
    }

    /**
     * Aplikovanie návrhového vzoru singleton.
     * @return vráti inštanciu tohto controllera
     */
    public static LoginController getInstance(){
        if (instance == null)instance = new LoginController();
        return instance;
    }

    /**
     * Priradí Login okno k tomuto controlleru.
     * @param lgView
     */
    public void PairController(LoginView lgView){
        this.loginView = lgView;
    }

    /**
     * Vyvolá načítanie databázy používateľov v novom vlákne.
     */
    public void loadUsers(){
        UserDB ActiveUserDB = new UserDB();
        ActiveUserDB.start();
    }

    /**
     * Vyvolá načítanie databázy zvierat v novom vlákne.
     */
    public void loadAnimals(){
        AnimalDB ActiveAnimalDB = new AnimalDB();
        ActiveAnimalDB.start();
    }

    /**
     * Vyvolá načítanie databázy pavilónov v novom vlákne.
     */
    public void loadPavilons(){
        PavilonDB ActivePavilonDB = new PavilonDB();
        ActivePavilonDB.start();
    }

    /**
     * Táto funkcia sa snaží prihlásiť používateľa podľa zadaného čísla tak, že ho porovná s databázou.
     * @param userID dostane ID pod ktorým sa chce používateľ prihlásiť.
     * @exception NumberFormatException vyhodí výnimku ak zadaný text od užívateľa nejde premeniť na číslo
     */
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

    /**
     * Vytvorí sa nové okno pre návštevníka.
     */
    public void VisitorOV(){
        new VisitorView().start(new Stage());
    }

    /**
     * Vytvorí sa nové okno pre ošetrovateľa.
     */
    public void HandlerOV(){
        new AniHandlerView().start(new Stage());
    }

    /**
     * Vytvorí sa nové okno pre Manažéra.
     */
    public void ManagerOV(){
        new ManagerView().start(new Stage());
    }

    /**
     * Vytvorí sa nové okno pre pokladníka.
     */
    public void CashierOV(){
        new CashierView().start(new Stage());
    }

    /**
     * Táto funkcia uloží všetky databázy a odhlási používateľa.
     */
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

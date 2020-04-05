package Controllers;

import View.*;
import Models.User;
import Help.UserDB;


public class LoginController {
    public LoginView loginView = null;

    public void PairController(LoginView lgView){
        this.loginView = lgView;
    }
    public void loadUsers(){
        UserDB.loadDB();
    }
    public void loginUser(String userID){
       User pickedUser = null;
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

    public void logoutUser(){
       UserDB.saveDB();
       this.loginView.logout();
    }
}

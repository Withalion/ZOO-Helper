package Controllers;

import View.*;
import Models.User;
import Help.UserDB;


public class LoginController {
    public LoginView loginView = null;

    public void PairController(LoginView lgView){
        this.loginView = lgView;
    }

    public void loginUser(String userID){
       User pickedUser = null;
       for (int i = 0; i <UserDB.users.size(); i++){
           if (UserDB.users.get(i).getID().equals(Integer.parseInt(userID))){
               pickedUser = UserDB.users.get(i);
               loginView.goodLogin(pickedUser.getName());
               pickedUser.LogIn();
               return;
           }
       }
       loginView.badLogin();
    }

    public void logoutUser(){
       this.loginView.logout();
    }
}

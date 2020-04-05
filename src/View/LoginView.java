package View;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import Controllers.LoginController;

public class LoginView extends Application {
    private LoginController loginController = new LoginController();
    private Label welcome = new Label("Welcome");
    private Label UserID = new Label("UserID");
    private Label wrong = new Label("User not found!");
    private TextField User = new TextField();
    public Button loginBT = new Button("Log In");
    public Button logoutBT = new Button("Log Out");
    public Pane pane = new Pane();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("ZOO");

        welcome.setLayoutX(150);
        welcome.setLayoutY(100);
        welcome.setFont(new Font("times new roman", 50));

        UserID.setLayoutX(100);
        UserID.setLayoutY(260);
        UserID.setFont(new Font("times new roman", 20));

        User.setLayoutX(200);
        User.setLayoutY(250);
        User.setMinSize(100,40);
        User.setText("");

        loginBT.setLayoutX(175);
        loginBT.setLayoutY(350);
        loginBT.setMinSize(150,75);
        loginBT.setFont(new Font("times new roman", 20));
        loginBT.setVisible(true);

        logoutBT.setLayoutX(175);
        logoutBT.setLayoutY(350);
        logoutBT.setMinSize(150,75);
        logoutBT.setFont(new Font("times new roman", 20));
        logoutBT.setVisible(false);

        wrong.setLayoutX(200);
        wrong.setLayoutY(300);
        wrong.setFont(new Font("times new roman", 15));
        wrong.setTextFill(Color.RED);
        wrong.setVisible(false);

        pane.getChildren().add(welcome);
        pane.getChildren().add(UserID);
        pane.getChildren().add(User);
        pane.getChildren().add(loginBT);
        pane.getChildren().add(logoutBT);
        pane.getChildren().add(wrong);

        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        loginController.PairController(this);

        loginBT.setOnAction(e ->{
            loginController.loginUser(User.getText());
        });

        logoutBT.setOnAction(e ->{
            loginController.logoutUser();
        });
    }

    public void goodLogin(String name){
        welcome.setText("Welcome" + name);
        welcome.setLayoutX(20);
        wrong.setVisible(false);
        loginBT.setVisible(false);
        logoutBT.setVisible(true);
    }

    public void badLogin(){
        wrong.setVisible(true);
    }

    public void logout(){
        welcome.setLayoutX(150);
        welcome.setLayoutY(100);
        welcome.setFont(new Font("times new roman", 50));

        UserID.setLayoutX(100);
        UserID.setLayoutY(260);
        UserID.setFont(new Font("times new roman", 20));

        User.setLayoutX(200);
        User.setLayoutY(250);
        User.setMinSize(100,40);
        User.setText("");

        loginBT.setLayoutX(175);
        loginBT.setLayoutY(350);
        loginBT.setMinSize(150,75);
        loginBT.setFont(new Font("times new roman", 20));
        loginBT.setVisible(true);

        logoutBT.setLayoutX(175);
        logoutBT.setLayoutY(350);
        logoutBT.setMinSize(150,75);
        logoutBT.setFont(new Font("times new roman", 20));
        logoutBT.setVisible(false);

        wrong.setLayoutX(200);
        wrong.setLayoutY(300);
        wrong.setFont(new Font("times new roman", 15));
        wrong.setTextFill(Color.RED);
        wrong.setVisible(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

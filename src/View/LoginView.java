package View;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import Controllers.LoginController;
/**
 * <h1>Zoo simulator</h1>
 * Toto je program pre správu zoologickej záhrady.
 * @author Matej Bagar
 */
public class LoginView extends Application {
    private LoginController loginController = LoginController.getInstance();
    private Label welcome = new Label("Welcome");
    private Label UserID = new Label("UserID");
    private Label wrong = new Label("User not found!");
    private Label Name = new Label("Meno");
    private TextField User = new TextField();
    public Button loginBT = new Button("Log In");
    public Button logoutBT = new Button("Log Out");
    public Pane pane = new Pane();

    /**
     * Táto metóda vyvolá vytvorenie hlavného okna hneď po spustení programu.
     * Priradí loginController a načíta alebo vytvorí dáta pre zvieratá, užívateľov a pavilóny.
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ZOO");

        welcome.setLayoutX(150);
        welcome.setLayoutY(100);
        welcome.setFont(new Font("times new roman", 50));

        Name.setLayoutX(150);
        Name.setLayoutY(150);
        Name.setFont(new Font("times new roman", 50));
        Name.setVisible(false);

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
        pane.getChildren().add(Name);

        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        loginController.PairController(this);
        loginController.loadUsers();
        loginController.loadAnimals();
        loginController.loadPavilons();

        loginBT.setOnAction(e ->{
            loginController.loginUser(User.getText());
        });

        logoutBT.setOnAction(e ->{
            loginController.logoutUser();
        });
    }

    /**
     * Updatne Login okno po úspešnom prihlásení a zobrazí meno prihláseného.
     * @param name
     */
    public void goodLogin(String name){
        Name.setText(name);
        Name.setVisible(true);
        wrong.setVisible(false);
        loginBT.setVisible(false);
        logoutBT.setVisible(true);
    }

    /**
     * Ukáže nesprávny login.
     */
    public void badLogin(){
        wrong.setVisible(true);
    }

    /**
     * Táto metóda sa zavolá po stlačení tlačidla pre odhlásenie, updatne sa login okno na pôvodný stav.
     */
    public void logout(){
        welcome.setLayoutX(150);
        welcome.setLayoutY(100);
        welcome.setText("Welcome");
        welcome.setFont(new Font("times new roman", 50));

        Name.setLayoutX(150);
        Name.setLayoutY(150);
        Name.setFont(new Font("times new roman", 50));
        Name.setVisible(false);

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

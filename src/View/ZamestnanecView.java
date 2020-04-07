package View;

import Controllers.LoginController;
import Controllers.ZamestnanecController;
import Models.Zamestnanec;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ZamestnanecView extends Application{
    private ZamestnanecController employeeController = ZamestnanecController.getInstance();
    public Pane pane = new Pane();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Overview");

        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        employeeController.PairEController(this);
    }
    public void openDoor(){

    }
    public void lockDoor(){

    }
}

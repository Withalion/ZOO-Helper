package View;

import Controllers.ZamestnanecController;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class CashierView extends Application{
    private ZamestnanecController employeeController = ZamestnanecController.getInstance(this);
    public Pane pane = new Pane();
    public Label action = new Label("Action to do: ");
    public ComboBox<String> actionChoice= new ComboBox<>();

    public void sceneBuilder(){
        action.setLayoutX(40);
        action.setLayoutY(50);
        action.setFont(new Font("times new roman", 30));

        actionChoice.getItems().addAll("Sell ticket", "Clock in", "Clock Out");
        actionChoice.setLayoutX(220);
        actionChoice.setLayoutY(50);
        actionChoice.setMinSize(70,40);

        pane.getChildren().add(action);
        pane.getChildren().add(actionChoice);
    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cashier Overview");
        sceneBuilder();
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        employeeController.PairEController(this);

    }
}

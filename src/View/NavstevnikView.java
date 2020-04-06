package View;

import Controllers.LoginController;
import Controllers.NavstevnikController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class NavstevnikView extends Application {
    private NavstevnikController visitorController = NavstevnikController.getInstance();
    public Pane pane = new Pane();

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visitor Overview");

        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        visitorController.PairVController(this);
    }
}

package View;

import AnimalPavilons.AnimalPavilon;
import Controllers.ZamestnanecController;
import Help.PavilonDB;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ZamestnanecView extends Application{
    private ZamestnanecController employeeController = ZamestnanecController.getInstance();
    public Pane pane = new Pane();
    public Button EntryButton = new Button("Enter");
    public Label doorOpen = new Label("Access granted");
    public Label doorClosed = new Label ("Access denied");
    public Label action = new Label("Action to do: ");
    public ComboBox<String> actionChoice= new ComboBox<>();
    public Label pavilon = new Label("Choose Pavilon: ");
    public ComboBox<AnimalPavilon> pavilonChoice = new ComboBox<AnimalPavilon>(FXCollections.observableList(PavilonDB.pavilons));

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            pavilon.setVisible(true);
            pavilonChoice.setVisible(true);
        }
    };
    public void sceneBuilder(){
        EntryButton.setLayoutX(175);
        EntryButton.setLayoutY(350);
        EntryButton.setVisible(true);
        EntryButton.setMinSize(150,75);
        EntryButton.setFont(new Font("times new roman", 20));

        doorOpen.setLayoutX(200);
        doorOpen.setLayoutY(300);
        doorOpen.setFont(new Font("times new roman", 20));
        doorOpen.setVisible(false);
        doorOpen.setTextFill(Color.GREEN);

        doorClosed.setLayoutX(200);
        doorClosed.setLayoutY(300);
        doorClosed.setFont(new Font("times new roman", 20));
        doorClosed.setVisible(false);
        doorClosed.setTextFill(Color.RED);

        action.setLayoutX(40);
        action.setLayoutY(50);
        action.setFont(new Font("times new roman", 30));

        actionChoice.getItems().addAll("Enter animal Pavilon", "Feed Animals", "Clock out");
        actionChoice.setLayoutX(220);
        actionChoice.setLayoutY(50);
        actionChoice.setMinSize(70,40);

        pavilon.setLayoutX(20);
        pavilon.setLayoutY(150);
        pavilon.setFont(new Font("times new roman", 30));
        pavilon.setVisible(false);


        pavilonChoice.setLayoutX(220);
        pavilonChoice.setLayoutY(150);
        pavilonChoice.setMinSize(70,40);
        pavilonChoice.setVisible(false);

        pane.getChildren().add(EntryButton);
        pane.getChildren().add(doorOpen);
        pane.getChildren().add(doorClosed);
        pane.getChildren().add(action);
        pane.getChildren().add(actionChoice);
        pane.getChildren().add(pavilon);
        pane.getChildren().add(pavilonChoice);
    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Overview");
        sceneBuilder();
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        employeeController.PairEController(this);

        EntryButton.setOnAction(e ->{
            employeeController.TryEnter(pavilonChoice.getValue());
        });
        actionChoice.setOnAction(event);
    }
    public void openDoor(){
        doorClosed.setVisible(false);
        doorOpen.setVisible(true);
    }
    public void lockDoor(){
        doorOpen.setVisible(false);
        doorClosed.setVisible(true);
    }
}

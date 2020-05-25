package View;

import AnimalPavilons.AnimalPavilon;
import Controllers.EmployeeController;
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

public class AniHandlerView extends Application{
    private EmployeeController employeeController = EmployeeController.getInstance(this);
    public Pane pane = new Pane();
    public Button EntryButton = new Button("Enter");
    public Label doorOpen = new Label("Access granted");
    public Label doorClosed = new Label ("Access denied");
    public Label action = new Label("Action to do: ");
    public ComboBox<String> actionChoice= new ComboBox<>();
    public Label pavilon = new Label("Choose Pavilon: ");
    public ComboBox<AnimalPavilon> pavilonChoice = new ComboBox<AnimalPavilon>(FXCollections.observableList(PavilonDB.pavilons));
    public Button FeedButton = new Button("Feed Animals");
    public TextArea FeedStatus = new TextArea();

    EventHandler<ActionEvent> DoIT = e -> {
        if (actionChoice.getValue().equals("Enter animal Pavilon")) {
            FeedButton.setVisible(false);
            FeedStatus.setVisible(false);
            pavilon.setVisible(true);
            pavilonChoice.setVisible(true);
            EntryButton.setVisible(true);
        }
        if (actionChoice.getValue().equals("Feed Animals")) {
            pavilon.setVisible(false);
            pavilonChoice.setVisible(false);
            EntryButton.setVisible(false);
            FeedButton.setVisible(true);
            FeedStatus.setVisible(true);
            doorOpen.setVisible(false);
            doorClosed.setVisible(false);
        }
    };
    public void sceneBuilder(){
        EntryButton.setLayoutX(175);
        EntryButton.setLayoutY(350);
        EntryButton.setVisible(false);
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

        actionChoice.getItems().addAll("Enter animal Pavilon", "Feed Animals");
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

        FeedButton.setLayoutX(175);
        FeedButton.setLayoutY(350);
        FeedButton.setVisible(false);
        FeedButton.setMinSize(150,75);
        FeedButton.setFont(new Font("times new roman", 20));

        FeedStatus.setLayoutX(30);
        FeedStatus.setLayoutY(100);
        FeedStatus.setVisible(false);
        FeedStatus.setMinSize(150, 200);
        FeedStatus.setMaxSize(440,200);

        pane.getChildren().add(EntryButton);
        pane.getChildren().add(doorOpen);
        pane.getChildren().add(doorClosed);
        pane.getChildren().add(action);
        pane.getChildren().add(actionChoice);
        pane.getChildren().add(pavilon);
        pane.getChildren().add(pavilonChoice);
        pane.getChildren().add(FeedButton);
        pane.getChildren().add(FeedStatus);
    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Animal Handler Overview");
        sceneBuilder();
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        employeeController.PairEController(this);

        EntryButton.setOnAction(e ->{
            employeeController.TryEnter(pavilonChoice.getValue());
        });
        FeedButton.setOnAction(event -> {
            employeeController.FeedAnimals();
        });
        actionChoice.setOnAction(DoIT);
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
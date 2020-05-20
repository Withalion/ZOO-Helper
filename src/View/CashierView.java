package View;

import Controllers.ZamestnanecController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
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
    public ComboBox<String> VisitorChoice= new ComboBox<>();
    public Label visitor = new Label("Choose visitor category: ");
    public Label visitorName = new Label("Insert visitor name: ");
    public TextField InsertName = new TextField();
    public Button SellTicket = new Button("Sell Ticket");
    public Label GoodCreate = new Label("Visitor successfully registered");
    public Label BadCreate = new Label("Visitor registration failed");
    public Button Repeat = new Button("Create new ticket");

    EventHandler<ActionEvent> ShowMore = e -> {
        if (actionChoice.getValue().equals("Sell ticket")) {
            VisitorChoice.setVisible(true);
            visitor.setVisible(true);
            visitorName.setVisible(true);
            InsertName.setVisible(true);
            SellTicket.setVisible(true);
            Repeat.setVisible(true);
        }
    };

    public void sceneBuilder(){
        action.setLayoutX(40);
        action.setLayoutY(50);
        action.setFont(new Font("times new roman", 30));

        actionChoice.getItems().addAll("Sell ticket");
        actionChoice.setLayoutX(220);
        actionChoice.setLayoutY(50);
        actionChoice.setMinSize(70,40);

        VisitorChoice.getItems().addAll("Child", "Adult", "Senior");
        VisitorChoice.setLayoutX(360);
        VisitorChoice.setLayoutY(120);
        VisitorChoice.setMinSize(70,40);
        VisitorChoice.setVisible(false);

        visitor.setLayoutX(40);
        visitor.setLayoutY(120);
        visitor.setFont(new Font("times new roman", 30));
        visitor.setVisible(false);

        visitorName.setLayoutX(80);
        visitorName.setLayoutY(190);
        visitorName.setFont(new Font("times new roman", 30));
        visitorName.setVisible(false);

        InsertName.setLayoutX(150);
        InsertName.setLayoutY(250);
        InsertName.setMinSize(100,40);
        InsertName.setText("");
        InsertName.setVisible(false);

        SellTicket.setLayoutY(400);
        SellTicket.setLayoutX(100);
        SellTicket.setMinSize(100, 70);
        SellTicket.setFont(new Font("times new roman", 20));
        SellTicket.setVisible(false);

        GoodCreate.setLayoutX(100);
        GoodCreate.setLayoutY(350);
        GoodCreate.setFont(new Font("times new roman", 20));
        GoodCreate.setVisible(false);
        GoodCreate.setTextFill(Color.GREEN);

        BadCreate.setLayoutX(100);
        BadCreate.setLayoutY(350);
        BadCreate.setFont(new Font("times new roman", 20));
        BadCreate.setVisible(false);
        BadCreate.setTextFill(Color.RED);

        Repeat.setLayoutY(400);
        Repeat.setLayoutX(300);
        Repeat.setMinSize(100, 70);
        Repeat.setFont(new Font("times new roman", 20));
        Repeat.setVisible(false);

        pane.getChildren().add(action);
        pane.getChildren().add(actionChoice);
        pane.getChildren().add(VisitorChoice);
        pane.getChildren().add(visitor);
        pane.getChildren().add(visitorName);
        pane.getChildren().add(InsertName);
        pane.getChildren().add(SellTicket);
        pane.getChildren().add(GoodCreate);
        pane.getChildren().add(BadCreate);
        pane.getChildren().add(Repeat);
    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cashier Overview");
        sceneBuilder();
        primaryStage.setScene(new Scene(pane, 500, 500));
        primaryStage.show();
        employeeController.PairEController(this);
        actionChoice.setOnAction(ShowMore);
        SellTicket.setOnAction(event -> {
            GoodCreate.setVisible(false);
            BadCreate.setVisible(false);
            employeeController.sellTicket(VisitorChoice.getValue(), InsertName.getText());
        });
        Repeat.setOnAction(event -> {
            InsertName.setText("");
            VisitorChoice.setValue(null);
            GoodCreate.setVisible(false);
            BadCreate.setVisible(false);
        });
    }
}

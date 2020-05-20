package View;

import Animals.Animal;
import Controllers.ZamestnanecController;
import Help.AnimalDB;
import Models.User;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class ManagerView extends Application{
    private ZamestnanecController employeeController = ZamestnanecController.getInstance(this);
    public Pane pane = new Pane();
    public Label action = new Label("Action to do: ");
    public ComboBox<String> actionChoice= new ComboBox<>();
    public Label staff = new Label("Pick employee: ");
    public ComboBox<User> staffChoice = new ComboBox<User>(FXCollections.observableList(employeeController.StaffDB));
    public Label name = new Label("Name: ");
    public TextField nameTXT = new TextField();
    public Label ID = new Label("ID: ");
    public TextField idTXT = new TextField();
    public Label Salary = new Label("Salary: ");
    public TextField salaryTXT = new TextField();
    public Button save = new Button("Save changes");
    public TextArea Animals = new TextArea();
    public Label animalADD = new Label("Add animal: ");
    public ComboBox<Animal> animalChoice = new ComboBox<>(FXCollections.observableList(AnimalDB.animals));
    public Label goodANI = new Label("Animal assigned to Caretaker");
    public Label wrongANI = new Label("Can't assign this animal to this worker");

    EventHandler <ActionEvent> doIT = event -> {
        if (actionChoice.getValue().equals("Manage Staff"))
            staffChoice.setVisible(true);
            staff.setVisible(true);
            name.setVisible(true);
            nameTXT.setVisible(true);
            ID.setVisible(true);
            idTXT.setVisible(true);
            Salary.setVisible(true);
            salaryTXT.setVisible(true);
            save.setVisible(true);
    };
    public void sceneBuilder(){
        action.setLayoutX(40);
        action.setLayoutY(50);
        action.setFont(new Font("times new roman", 30));

        actionChoice.getItems().addAll("Manage Staff", "Hire Staff", "Fire Staff", "Buy Animal", "Sell Animal");
        actionChoice.setLayoutX(220);
        actionChoice.setLayoutY(50);
        actionChoice.setMinSize(70,40);

        staff.setLayoutX(40);
        staff.setLayoutY(100);
        staff.setFont(new Font("times new roman", 30));
        staff.setVisible(false);

        staffChoice.setLayoutX(240);
        staffChoice.setLayoutY(100);
        staffChoice.setMinSize(70,40);
        staffChoice.setVisible(false);

        name.setLayoutX(40);
        name.setLayoutY(150);
        name.setFont(new Font("times new roman", 30));
        name.setVisible(false);

        nameTXT.setLayoutX(150);
        nameTXT.setLayoutY(150);
        nameTXT.setMinSize(100,40);
        nameTXT.setText("");
        nameTXT.setVisible(false);

        Salary.setLayoutX(40);
        Salary.setLayoutY(250);
        Salary.setFont(new Font("times new roman", 30));
        Salary.setVisible(false);

        salaryTXT.setLayoutX(150);
        salaryTXT.setLayoutY(250);
        salaryTXT.setMinSize(100,40);
        salaryTXT.setText("");
        salaryTXT.setVisible(false);

        ID.setLayoutX(40);
        ID.setLayoutY(200);
        ID.setFont(new Font("times new roman", 30));
        ID.setVisible(false);

        idTXT.setLayoutX(150);
        idTXT.setLayoutY(200);
        idTXT.setMinSize(100,40);
        idTXT.setText("");
        idTXT.setVisible(false);

        save.setLayoutX(200);
        save.setLayoutY(400);
        save.setMinSize(100,70);
        save.setFont(new Font("times new roman", 20));
        save.setVisible(false);

        Animals.setLayoutX(350);
        Animals.setLayoutY(150);
        Animals.setVisible(false);
        Animals.setMinSize(150, 200);
        Animals.setMaxSize(300,200);

        animalChoice.setLayoutX(70);
        animalChoice.setLayoutY(350);
        animalChoice.setMinSize(70,40);
        animalChoice.setVisible(false);

        animalADD.setLayoutX(100);
        animalADD.setLayoutY(300);
        animalADD.setFont(new Font("times new roman", 30));
        animalADD.setVisible(false);

        wrongANI.setLayoutX(350);
        wrongANI.setLayoutY(360);
        wrongANI.setFont(new Font("times new roman", 20));
        wrongANI.setTextFill(Color.RED);
        wrongANI.setVisible(false);

        goodANI.setLayoutX(350);
        goodANI.setLayoutY(360);
        goodANI.setFont(new Font("times new roman", 20));
        goodANI.setTextFill(Color.GREEN);
        goodANI.setVisible(false);

        pane.getChildren().add(action);
        pane.getChildren().add(actionChoice);
        pane.getChildren().add(staff);
        pane.getChildren().add(staffChoice);
        pane.getChildren().add(name);
        pane.getChildren().add(ID);
        pane.getChildren().add(Salary);
        pane.getChildren().add(idTXT);
        pane.getChildren().add(nameTXT);
        pane.getChildren().add(salaryTXT);
        pane.getChildren().add(save);
        pane.getChildren().add(Animals);
        pane.getChildren().add(animalChoice);
        pane.getChildren().add(animalADD);
        pane.getChildren().add(goodANI);
        pane.getChildren().add(wrongANI);
    }
    public void start(Stage primaryStage) {
        employeeController.CreateStaffDB();
        primaryStage.setTitle("Manager Overview");
        sceneBuilder();
        primaryStage.setScene(new Scene(pane, 700, 500));
        primaryStage.show();
        employeeController.PairEController(this);
        actionChoice.setOnAction(doIT);
        staffChoice.getSelectionModel().selectedItemProperty().addListener((ChangeListener<User>) (ov, oldValue, newValue) -> employeeController.updateDetails(newValue));
        animalChoice.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Animal>) (ov, oldValue, newValue) -> employeeController.AddAnimal(newValue, this.staffChoice.getValue()));
        save.setOnAction(e ->{
            employeeController.saveDATA(this.staffChoice.getValue());
        });
    }
}

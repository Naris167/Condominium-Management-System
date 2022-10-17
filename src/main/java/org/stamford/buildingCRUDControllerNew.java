package org.stamford;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class buildingCRUDControllerNew implements Initializable {
    @FXML
    private Label IDLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField conBudgetTextField;
    @FXML
    private DatePicker dateOfConstructionPicker;
    @FXML
    private DatePicker dateOfCompletePicker;
    @FXML
    private TextField numberOfUnitTextField;
    @FXML
    private TextField numberOfOwnedUnitTextField;
    @FXML
    private ChoiceBox<String> sizeChoiceBox;

    private Controller parentController;
    private Building currentBuilding;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    private String[] sizeList = {"Large", "Medium", "Small"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sizeChoiceBox.getItems().addAll(sizeList);
        sizeChoiceBox.setOnAction(this::getRole);
    }

    public void getRole(ActionEvent actionEvent){
        String role = sizeChoiceBox.getValue();
        System.out.println(role);
    }

    public void initialize() {
    }
    public void okBuildingCRUDOnAction (ActionEvent actionEvent) {

        if(nameTextField.getText().isEmpty()
                ||locationTextField.getText().isEmpty()
                ||conBudgetTextField.getText().isEmpty()
                ||dateOfConstructionPicker.getValue().toString().isEmpty()
                ||dateOfCompletePicker.getValue().toString().isEmpty()
                ||numberOfUnitTextField.getText().isEmpty()
                ||sizeChoiceBox.getValue().isEmpty()
        ){
            BuildingGenerator.decreaseCounter();
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(this.stage);
            alert.getDialogPane().setContentText("Please fill all the information and make sure that the input are correct");
            alert.getDialogPane().setHeaderText("Incorrect or Invalid Information");
            alert.showAndWait();
        } else {
            BuildingGenerator buildingGenerator = new BuildingGenerator();
            Building newBuilding = buildingGenerator.next();
            newBuilding.setName(nameTextField.getText());
            newBuilding.setLocation(locationTextField.getText());
            newBuilding.setConBudget(Float.parseFloat(conBudgetTextField.getText()));
            newBuilding.setConDate(dateOfConstructionPicker.getValue());
            newBuilding.setCompleteDate(dateOfCompletePicker.getValue());
            newBuilding.setNumberOfUnit(Integer.parseInt(numberOfUnitTextField.getText()));
            newBuilding.setOwnedUnit(Integer.parseInt(numberOfOwnedUnitTextField.getText()));
            newBuilding.setSize(sizeChoiceBox.getValue());
            virtualDataBase.buildings.add(newBuilding);
            if (Objects.nonNull(stage))
                stage.close();
        }
    }
    public void cancelBuildingCRUDOnAction (ActionEvent actionEvent) {
        if (Objects.nonNull(stage))
            stage.close();
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setCurrentBuilding(Building building) {
        this.currentBuilding = building;
        int i = 1;
        IDLabel.setText("ID: " + (currentBuilding.getID() + i));

    }
    public void setParentController(Controller controller) {
        this.parentController = controller;
    }

//    public void setCurrentBuilding(Building building) {
//        this.currentBuilding = building;
//        int i = 1;
//        IDLabel.setText("ID: " + (currentBuilding.getID() + i));
//    }
}
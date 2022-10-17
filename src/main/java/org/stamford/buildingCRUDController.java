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

public class buildingCRUDController implements Initializable {
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
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(this.stage);
        alert.getDialogPane().setContentText("The selected item has been updated in the system");
        alert.getDialogPane().setHeaderText("Edited Selected Item");
        alert.showAndWait();

        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setName(
                nameTextField.getText());
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setLocation(
                locationTextField.getText());
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setConBudget(Float.parseFloat(
                conBudgetTextField.getText()));
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setConDate(dateOfConstructionPicker.getValue());
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setCompleteDate(dateOfCompletePicker.getValue());
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setNumberOfUnit(Integer.parseInt(numberOfUnitTextField.getText()));
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setOwnedUnit(Integer.parseInt(numberOfOwnedUnitTextField.getText()));
        virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)).setSize(sizeChoiceBox.getValue());
        parentController.notifyBuildingUpdate(virtualDataBase.buildings.get(virtualDataBase.buildings.indexOf(currentBuilding)));
        if (Objects.nonNull(stage))
            stage.close();
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
        IDLabel.setText("ID: " + currentBuilding.getID());
        nameTextField.setText(currentBuilding.getName());
        locationTextField.setText(currentBuilding.getLocation());
        conBudgetTextField.setText(Double.toString(currentBuilding.getConBudget()));
        dateOfConstructionPicker.setValue(currentBuilding.getConDate());
        dateOfCompletePicker.setValue(currentBuilding.getCompleteDate());
        numberOfUnitTextField.setText(Integer.toString(currentBuilding.getNumberOfUnit()));
        numberOfOwnedUnitTextField.setText(Integer.toString(currentBuilding.getOwnedUnit()));
        sizeChoiceBox.setValue(currentBuilding.getSize());
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
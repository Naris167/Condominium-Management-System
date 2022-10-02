package org.stamford;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Objects;

public class userCRUDController {
    @FXML
    private Label IDLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private TextField emailTextField;
    @FXML
    private userManagementController parentController;
    private User currentUser;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void initialize() {
    }
    public void okOnAction (ActionEvent actionEvent) {
        User newUser = new User(
                nameTextField.getText(),
                surnameTextField.getText(),
                emailTextField.getText(),
                passwordTextField.getText(),
                dateOfBirthDatePicker.getValue()
        );
        newUser.setID(currentUser.getID());
        parentController.notifyUserUpdate(newUser);
        if (Objects.nonNull(stage))
            stage.close();
    }

    public void cancelOnAction (ActionEvent actionEvent) {
        if (Objects.nonNull(stage))
            stage.close();
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setCurrentUser(User user) {
        this.currentUser = user;
        IDLabel.setText("ID: " + currentUser.getID());
        nameTextField.setText(currentUser.getName());
        passwordTextField.setText(currentUser.getPassword());
        surnameTextField.setText(currentUser.getSurname());
        dateOfBirthDatePicker.setValue(currentUser.getBirthDate());
        emailTextField.setText(currentUser.getEmail());
        }
    public void setParentController(userManagementController controller) {
        this.parentController = controller;
    }
}

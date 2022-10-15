package org.stamford;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class userCRUDController implements Initializable {
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
    private ChoiceBox<String> roleChoiceBox;

    private Controller parentController;
    private User currentUser;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    private String[] roleList = {"Administrator", "Resident", "Guest"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        roleChoiceBox.getItems().addAll(roleList);
        roleChoiceBox.setOnAction(this::getRole);
    }

    public void getRole(ActionEvent actionEvent){
        String role = roleChoiceBox.getValue();
        System.out.println(role);
    }


    public void initialize() {
    }
    public void okCRUDOnAction (ActionEvent actionEvent) {
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setName(nameTextField.getText());
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setSurname(surnameTextField.getText());
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setEmail(emailTextField.getText());
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setPassword(passwordTextField.getText());
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setBirthDate(dateOfBirthDatePicker.getValue());
        virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)).setRole(roleChoiceBox.getValue());
        parentController.notifyUserUpdate(virtualDataBase.users.get(virtualDataBase.users.indexOf(currentUser)));
        if (Objects.nonNull(stage))
            stage.close();
    }
    public void cancelCRUDOnAction (ActionEvent actionEvent) {
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
        roleChoiceBox.setValue(currentUser.getRole());
    }
    public void setParentController(Controller controller) {
        this.parentController = controller;
    }
}
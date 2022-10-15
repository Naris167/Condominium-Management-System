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

public class userCRUDControllerCreateNew implements Initializable {
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
    public void okOnAction (ActionEvent actionEvent) {

        UserGenerator userGenerator = new UserGenerator();
        User newUser = userGenerator.next();
        newUser.setName(nameTextField.getText());
        newUser.setSurname(surnameTextField.getText());
        newUser.setEmail(emailTextField.getText());
        newUser.setPassword(passwordTextField.getText());
        newUser.setBirthDate(dateOfBirthDatePicker.getValue());
        newUser.setRole(roleChoiceBox.getValue());

        virtualDataBase.users.add(newUser);
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
        int i = 1;
        IDLabel.setText("ID: " + (currentUser.getID() + i));
        }
    public void setParentController(topController controller) {
        this.parentController = controller;
    }
}

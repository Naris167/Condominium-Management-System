package org.stamford;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Objects;

public class userCRUDControllerCreateNew {
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
//    private ObservableList<User> users;
    private Scene scene;
    private Parent parent;

    @FXML
    private TableView<User> usersTableView;
    @FXML
    private TableColumn<User, String> IDCol;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> surnameCol;
    @FXML
    private TableColumn<User, String> dateOfBirthCol;
    @FXML
    private TableColumn<User, String> emailCol;
    private Integer currentUserIndex;


    public void initialize() {
    }
    public void okOnAction (ActionEvent actionEvent) {
        User user1 = new User(
                nameTextField.getText(),
                surnameTextField.getText(),
                emailTextField.getText(),
                passwordTextField.getText(),
                dateOfBirthDatePicker.getValue()
        );
        user1.setID(parentController.getLastUserID() + 1);
        userList.users.add(user1);
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
    public void setParentController(userManagementController controller) {
        this.parentController = controller;
    }
}

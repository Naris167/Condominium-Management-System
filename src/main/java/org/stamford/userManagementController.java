package org.stamford;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class userManagementController {
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
    private Stage stage;
    private Scene scene;
    private Parent parent;
//    private ObservableList<User> users;
    private User currentUser;
    private Integer currentUserIndex;

    public void initialize() {
        refresh(userList.users.get(0));
    }

    public void refresh(User user) {
        usersTableView.setItems(userList.users);
        usersTableView.setEditable(true);

        // Obtain TableView SelectionModel Instance
        TableView.TableViewSelectionModel<User> selectionModel = usersTableView.getSelectionModel();
        // set selection mode to only 1 row
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectionModel.select(0);
        currentUser = user;
        currentUserIndex = 0;
        IDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateOfBirthCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        selectionModel.selectedItemProperty().addListener(
                new ChangeListener<User>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends User> observable, User oldValue, User newValue) {
                        if (Objects.nonNull(newValue)) {
                            System.out.println(
                                    "Selection changed. User ID = " + newValue.getID());
                            currentUser = newValue;
                        }
                    }
                }
        );

        selectionModel.selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        if (Objects.nonNull(newValue)) {
                            System.out.println("Selection changed. index = " + newValue);
                            currentUserIndex = newValue.intValue();
                        }
                    }
                });
    }

    public void editUserOnAction(ActionEvent actionEvent) throws IOException {
        Stage userCRUDStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-crud.fxml"));
        Parent root = loader.load();
        userCRUDController controller = loader.getController();
        controller.setStage(userCRUDStage);
        controller.setCurrentUser(currentUser);
        controller.setParentController(this);
        userCRUDStage.setScene(new Scene(root));
        userCRUDStage.setTitle("Edit User CRUD");
        userCRUDStage.initModality(Modality.WINDOW_MODAL);
        userCRUDStage.initOwner(stage);
        userCRUDStage.show();
//        refresh(currentUser);
    }

    public void deleteUserOnAction(ActionEvent actionEvent) {
        usersTableView.getItems().remove(usersTableView.getSelectionModel().getSelectedItem());
        // Deleting user from data model goes here
    }

    public void newUserOnAction(ActionEvent actionEvent) throws IOException {
        Stage userCRUDStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-crud-createNew.fxml"));
        Parent root = loader.load();
        userCRUDControllerCreateNew controller = loader.getController();
        controller.setStage(userCRUDStage);
//        User noUser = User.createNoUser();
        controller.setCurrentUser(userList.users.get(userList.users.size()-1));
        controller.setParentController(this);
        userCRUDStage.setScene(new Scene(root));
        userCRUDStage.setTitle("Create New User CRUD");
        userCRUDStage.initModality(Modality.WINDOW_MODAL);
        userCRUDStage.initOwner(stage);
        userCRUDStage.show();
    }

    public void okOnAction(ActionEvent actionEvent) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void notifyUserUpdate(User user) {
        userList.users.set(currentUserIndex, user);
    }

    public int getLastUserID(){
        return userList.users.get(userList.users.size()-1).getID();
    }
}
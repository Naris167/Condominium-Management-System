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
    private ObservableList<User> users;
    private User currentUser;
    private Integer currentUserIndex;

    public void initialize() {
        currentUser = new User();
        // populate user table with system users
        // We don’t have a database yet, so we
        // have to create few dummy users.
        User user1 = new User(
                "Ehsan",
                "Ali",
                "ehsan.ali@stamford.edu",
                "pass123",
                LocalDate.of(1980, 1, 1)
        );
        user1.setID(1);

        User user2 = new User(
                "Sara",
                "Ali",
                "sara.ali@stamford.edu",
                "sarapass123",
                LocalDate.of(1990, 2, 3)
        );
        user2.setID(2);

        User user3 = new User("Arash",
                "Ghasemi",
                "arash.ghasemi@gmail.com",
                "arash123",
                LocalDate.of(1981, 5, 6)
        );
        user3.setID(3);

        users = FXCollections.observableArrayList(
                user1, user2, user3
        );
        for (int i = 1; i < 20; i++) {
            User user = new User(
                    "Arash" + i,
                    "Ghasemi" + i,
                    "arash.ghasemi" + i + "@gmail.com",
                    "arash123" + i,
                    LocalDate.of(1981, 5, i)
            );
            user.setID(i + 3);
            users.add(user);
        }
        usersTableView.setItems(users);
        usersTableView.setEditable(true);

        // Obtain TableView SelectionModel Instance
        TableView.TableViewSelectionModel<User> selectionModel = usersTableView.getSelectionModel();
        // set selection mode to only 1 row
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectionModel.select(0);
        currentUser = user1;
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
//        Stage userCRUDStage = new Stage();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-crud.fxml"));
//        Parent root = loader.load();
//        userCRUDController controller = loader.getController();
//        controller.setStage(userCRUDStage);
//        controller.setCurrentUser(currentUser);
//        controller.setParentController(this);
//        userCRUDStage.setScene(new Scene(root));
//        userCRUDStage.setTitle("User CRUD");
//        userCRUDStage.initModality(Modality.WINDOW_MODAL);
//        userCRUDStage.initOwner(stage);
//        userCRUDStage.show();
    }

    public void deleteUserOnAction(ActionEvent actionEvent) {
        usersTableView.getItems().remove(usersTableView.getSelectionModel().getSelectedItem());
        // Deleting user from data model goes here
    }

    public void newUserOnAction(ActionEvent actionEvent) throws IOException {
//        Stage userCRUDStage = new Stage();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-crud.fxml"));
//        Parent root = loader.load();
//        userCRUDController controller = loader.getController();
//        controller.setStage(userCRUDStage);
//        User noUser = User.createNoUser();
//        controller.setCurrentUser(noUser);
//        controller.setParentController(this);
//        userCRUDStage.setScene(new Scene(root));
//        userCRUDStage.setTitle("User CRUD");
//        userCRUDStage.initModality(Modality.WINDOW_MODAL);
//        userCRUDStage.initOwner(stage);
//        userCRUDStage.show();
    }

    public void okOnAction(ActionEvent actionEvent) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void notifyUserUpdate(User user) {
        users.set(currentUserIndex, user);
    }
}
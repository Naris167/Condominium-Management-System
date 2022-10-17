package org.stamford;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;
import java.util.Optional;

public class topController extends Controller {
    //User Declaration
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
    @FXML
    private TableColumn<User, String> roleCol;
    private ObservableList<User> users;
    private User currentUser;
    private Integer currentUserIndex;
    private Controller parentController;


    //Buildings Declaration
    @FXML
    private TableView<Building> buildingsTableView;
    @FXML
    private TableColumn<Building, String> buildingIDCol;
    @FXML
    private TableColumn<Building, String> buildingNameCol;
    @FXML
    private TableColumn<Building, String> LocationCol;
    @FXML
    private Text numberOfUnit;
    @FXML
    private Text emptyUnit;
    @FXML
    private Text ownedUnit;
    @FXML
    private Text conBudget;
    @FXML
    private Text conDate;
    @FXML
    private Text completeDate;
    @FXML
    private Text buildingSize;
    private ObservableList<Building> buildings;
    private Building currentBuilding;
    private Integer currentBuildingIndex;

    //Top Declaration
    @FXML
    MenuBar menuBar;
    @FXML
    private BorderPane borderPane;
    @FXML
    private HBox statusBarHBox;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Label systemMsgLabel;
    @FXML
    private Label currentUserLabel;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label label;
    private Parent centerLoginFXML, centerMainFXML;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private boolean aUserHasLoggedIn;
    private int userLoginIndex = 0;

    public topController() throws IOException {
        aUserHasLoggedIn = false;
    }

    /**
     * Calling "Login" menu and its controller
     */
    public void loginMenuOnAction(ActionEvent event) throws IOException {
        URL url = getClass().getResource("login.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        GridPane loginFXML = loader.load();
        if(!aUserHasLoggedIn) {
            System.out.println("Login menu item is clicked for 'Login'.");
            borderPane.setCenter(loginFXML);
        } else {
            System.out.println("Login menu item is clicked for 'Change User'.");
            currentUserLabel.setText("Current User: None");
            systemMsgLabel.setText("You must login before using Stamford-CMS");
            aUserHasLoggedIn = false;
            User noUser = User.createNoUser();
            mainApp.getMainApplication().setCurrentUser(noUser);
            borderPane.setCenter(loginFXML);
        }
    }

    private boolean verifyLogin(String givenUser, String givePass){
//        virtualDataBase.users = users;
        for(int i = 0; i < virtualDataBase.users.size(); i++ ){
             if(virtualDataBase.users.get(i).getName().equals(givenUser) && virtualDataBase.users.get(i).getPassword().equals(givePass)){
                 userLoginIndex = i;
                 return true;
             } else {
                 break;
             }
        }
        return false;
    }

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws IOException {
//        if (Objects.equals(passwordPasswordField.getText(), "123")) {
        if (verifyLogin(usernameTextField.getText(), passwordPasswordField.getText())) {
            aUserHasLoggedIn = true;
            String username = usernameTextField.getText();
            currentUserLabel.setText("Current User: " + username + "   Role: " + virtualDataBase.users.get(userLoginIndex).getRole());
            systemMsgLabel.setText("User '" + username + "' is authenticated successfully.");
            // Right now we don’t have a place to save the registered users. If you save the users in some place
            // then later you can come and fetch the user data.
            // That place can a simple file or a database.
            User user = new User();
            user.setName(username);
            // main application instance ! we only have one instance!
            // Every time I want to access my main JavaFX Application instance (in our case it is called mainApp)
            // I only need to call the static method mainApp. getMainApplication()
            mainApp.getMainApplication().setCurrentUser(user);
            // switch to main scene
            URL url = getClass().getResource("main.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane mainFXML = loader.load();
            borderPane.setCenter(mainFXML);
            // Send signal to model: A new user has logged in.
        } else {
            systemMsgLabel.setText("Authentication failed, try again.");

            Alert.AlertType type = Alert.AlertType.ERROR;
            Alert alert = new Alert(type, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(this.stage);

            alert.getDialogPane().setContentText("Please make sure that the Username and Password are correct. (case sensitive)");

            alert.getDialogPane().setHeaderText("Incorrect Username or Password");

            alert.showAndWait();

        }
    }

    /**
     * Calling "Main" menu and its controller
     */
    public void systemUserManagementOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println("System User Management menu item is clicked.");
        URL url = getClass().getResource("user-mgmt.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        GridPane systemUserManagementFXML = loader.load();
        borderPane.setCenter(systemUserManagementFXML);
        refresh(virtualDataBase.users.get(0));
    }

    public void condominiumManagementOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Condominium Management menu item is clicked.");
        URL url = getClass().getResource("building-mgmt.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        GridPane condominiumUserManagementFXML = loader.load();
        borderPane.setCenter(condominiumUserManagementFXML);
        refresh(virtualDataBase.buildings.get(0));
        numberOfUnit.setText(Integer.toString(currentBuilding.getNumberOfUnit()));
        emptyUnit.setText(Integer.toString(currentBuilding.getEmptyUnit()));
        ownedUnit.setText(Integer.toString(currentBuilding.getOwnedUnit()));
        conBudget.setText(Double.toString(currentBuilding.getConBudget()));
        conDate.setText(currentBuilding.getConDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        completeDate.setText(currentBuilding.getCompleteDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        buildingSize.setText(currentBuilding.getSize());
    }

    public void systemSettingOnAction(ActionEvent actionEvent) throws IOException {
        // TODO: To be implemented
    }

    public void logoutMenuOnAction(ActionEvent actionEvent) throws IOException {
        if(aUserHasLoggedIn) {
            System.out.println("Logout menu item is clicked.");
            currentUserLabel.setText("Current User: None");
            systemMsgLabel.setText("You must login before using Stamford-CMS");
            aUserHasLoggedIn = false;
            // Set current user to no one
            User noUser = User.createNoUser();
            // Again I am able to access main application instance (this instance is just one !)
            mainApp.getMainApplication().setCurrentUser(noUser); // This is actually logging out !
            // Send a signal to server that current user has logged out
            // Show login window
            URL url = getClass().getResource("login.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane loginFXML = loader.load();
            borderPane.setCenter(loginFXML);
        } else {
            System.out.println("Already Logged Out!!!");
        }
    }


    /**
     * Calling "System User Management" menu and its controller
     */
    public void refresh(User user) {
        usersTableView.setItems(virtualDataBase.users);
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
        roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));
        selectionModel.selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observable,
                                User oldValue, User newValue) {
                if (Objects.nonNull(newValue)) {
                    System.out.println("Selection changed. User ID = " +
                            newValue.getID());
                    currentUser = newValue;
                }
            }
        });
        selectionModel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number>
                                        observable, Number oldValue, Number newValue) {
                if (Objects.nonNull(newValue)) {
                    System.out.println("Selection changed. index = " + newValue
                    );
                    currentUserIndex = newValue.intValue();
                }
            }
        });
    }
    public void refresh(Building building) {
        buildingsTableView.setItems(virtualDataBase.buildings);
        buildingsTableView.setEditable(true);
        // Obtain TableView SelectionModel Instance
        TableView.TableViewSelectionModel<Building> selectionModel = buildingsTableView.getSelectionModel();
        // set selection mode to only 1 row
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        selectionModel.select(0);
        currentBuilding = building;
        currentBuildingIndex = 0;
        buildingIDCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        buildingNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Building>() {
            @Override
            public void changed(ObservableValue<? extends Building> observable,
                                Building oldValue, Building newValue) {
                if (Objects.nonNull(newValue)) {
                    System.out.println("Selection changed. Building ID = " +
                            newValue.getID());
                    currentBuilding = newValue;
                    numberOfUnit.setText(Integer.toString(currentBuilding.getNumberOfUnit()));
                    emptyUnit.setText(Integer.toString(currentBuilding.getEmptyUnit()));
                    ownedUnit.setText(Integer.toString(currentBuilding.getOwnedUnit()));
                    conBudget.setText(Double.toString(currentBuilding.getConBudget()));
                    conDate.setText(currentBuilding.getConDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
                    completeDate.setText(currentBuilding.getCompleteDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
                    buildingSize.setText(currentBuilding.getSize());
                }
            }
        });
        selectionModel.selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number>
                                        observable, Number oldValue, Number newValue) {
                if (Objects.nonNull(newValue)) {
                    System.out.println("Selection changed. index = " + newValue
                    );
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
        userCRUDStage.initModality(Modality.APPLICATION_MODAL);
        userCRUDStage.initOwner(stage);
        userCRUDStage.show();
    }

    public void deleteUserOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the selected item?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation to Delete Item");
        ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
        if (result == ButtonType.YES) {
            usersTableView.getItems().remove(usersTableView.getSelectionModel().getSelectedItem());
            // Deleting user from data model goes here
        }
    }

    public void newUserOnAction(ActionEvent actionEvent) throws IOException {
        Stage userCRUDStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-crud-createNew.fxml"));
        Parent root = loader.load();
        userCRUDControllerCreateNew controller = loader.getController();
        controller.setStage(userCRUDStage);
        controller.setCurrentUser(virtualDataBase.users.get(virtualDataBase.users.size() - 1));
        controller.setParentController(this);
        userCRUDStage.setScene(new Scene(root));
        userCRUDStage.setTitle("Create New User CRUD");
        userCRUDStage.initModality(Modality.WINDOW_MODAL);
        userCRUDStage.initOwner(stage);
        userCRUDStage.show();
    }

    public void okMGMTOnAction(ActionEvent actionEvent) throws IOException {
        URL url = getClass().getResource("main.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        GridPane mainFXML = loader.load();
        borderPane.setCenter(mainFXML);
    }

    /**
     * Calling "Building Management" menu and its controller
     */
    public void editBuildingOnAction(ActionEvent actionEvent) throws IOException {
        Stage buildingCRUDStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("building-crud.fxml"));
        Parent root = loader.load();
        buildingCRUDController controller = loader.getController();
        controller.setStage(buildingCRUDStage);
        controller.setCurrentBuilding(currentBuilding);
        controller.setParentController(this);
        buildingCRUDStage.setScene(new Scene(root));
        buildingCRUDStage.setTitle("Edit Building CRUD");
        buildingCRUDStage.initModality(Modality.APPLICATION_MODAL);
        buildingCRUDStage.initOwner(stage);
        buildingCRUDStage.show();
    }

    public void deleteBuildingOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the selected item?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Confirmation to Delete Item");
        ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
        if (result == ButtonType.YES) {
            buildingsTableView.getItems().remove(buildingsTableView.getSelectionModel().getSelectedItem());
            // Deleting user from data model goes here
        }
    }


    public void newBuildingOnAction(ActionEvent actionEvent) throws IOException {
        Stage createBuildingCRUDStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("building-crudNew.fxml"));
        Parent root = loader.load();
        buildingCRUDControllerNew controller = loader.getController();
        controller.setStage(createBuildingCRUDStage);
        controller.setCurrentBuilding(virtualDataBase.buildings.get(virtualDataBase.buildings.size() - 1));
        controller.setParentController(this);
        createBuildingCRUDStage.setScene(new Scene(root));
        createBuildingCRUDStage.setTitle("Create New Building CRUD");
        createBuildingCRUDStage.initModality(Modality.WINDOW_MODAL);
        createBuildingCRUDStage.initOwner(stage);
        createBuildingCRUDStage.show();
    }

    public void okCondoMGMTOnAction(ActionEvent actionEvent) throws IOException {
        URL url = getClass().getResource("main.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        GridPane mainFXML = loader.load();
        borderPane.setCenter(mainFXML);
    }




    /**
     * This is the menu and controller for "Top"
     */
    public void exitMenuOnAction(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void notifyUserUpdate(User user) {
        virtualDataBase.users.set(currentUserIndex, user);
    }
    @Override
    void notifyBuildingUpdate(Building building) {
        virtualDataBase.buildings.set(currentBuildingIndex, building);
    }

    public void addUserMenuOnAction(ActionEvent actionEvent) throws IOException {
        if (aUserHasLoggedIn) {
            System.out.println("System User Management menu item is opened via 'Add' menu bar with 'New user' option.");
            URL url = getClass().getResource("user-mgmt.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane systemUserManagementFXML = loader.load();
            borderPane.setCenter(systemUserManagementFXML);
            refresh(virtualDataBase.users.get(0));

            Stage userCRUDStage = new Stage();
            loader = new FXMLLoader(getClass().getResource("user-crud-createNew.fxml"));
            Parent root = loader.load();
            userCRUDControllerCreateNew controller = loader.getController();
            controller.setStage(userCRUDStage);
            controller.setCurrentUser(virtualDataBase.users.get(virtualDataBase.users.size() - 1));
            controller.setParentController(this);
            userCRUDStage.setScene(new Scene(root));
            userCRUDStage.setTitle("Create New User CRUD");
            userCRUDStage.initModality(Modality.WINDOW_MODAL);
            userCRUDStage.initOwner(stage);
            userCRUDStage.show();
        }
    }

    public void editUserMenuOnAction(ActionEvent actionEvent) throws IOException {
        if (aUserHasLoggedIn) {
            System.out.println("System User Management menu item is opened via 'Edit' menu bar");
            URL url = getClass().getResource("user-mgmt.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane systemUserManagementFXML = loader.load();
            borderPane.setCenter(systemUserManagementFXML);
            refresh(virtualDataBase.users.get(0));
        }
    }

    public void addUnitAndBuildingMenuOnAction(ActionEvent actionEvent) throws IOException {
        if (aUserHasLoggedIn) {
            System.out.println("Condominium Management menu item is opened via 'Add Building' menu bar with 'New user' option.");
            URL url = getClass().getResource("building-mgmt.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane condominiumUserManagementFXML = loader.load();
            borderPane.setCenter(condominiumUserManagementFXML);
            refresh(virtualDataBase.buildings.get(0));
            numberOfUnit.setText(Integer.toString(currentBuilding.getNumberOfUnit()));
            emptyUnit.setText(Integer.toString(currentBuilding.getEmptyUnit()));
            ownedUnit.setText(Integer.toString(currentBuilding.getOwnedUnit()));
            conBudget.setText(Double.toString(currentBuilding.getConBudget()));
            conDate.setText(currentBuilding.getConDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            completeDate.setText(currentBuilding.getCompleteDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            buildingSize.setText(currentBuilding.getSize());

            Stage createBuildingCRUDStage = new Stage();
            loader = new FXMLLoader(getClass().getResource("building-crudNew.fxml"));
            Parent root = loader.load();
            buildingCRUDControllerNew controller = loader.getController();
            controller.setStage(createBuildingCRUDStage);
            controller.setCurrentBuilding(virtualDataBase.buildings.get(virtualDataBase.buildings.size() - 1));
            controller.setParentController(this);
            createBuildingCRUDStage.setScene(new Scene(root));
            createBuildingCRUDStage.setTitle("Create New Building CRUD");
            createBuildingCRUDStage.initModality(Modality.WINDOW_MODAL);
            createBuildingCRUDStage.initOwner(stage);
            createBuildingCRUDStage.show();
        }
    }

    public void editUnitAndBuildingMenuOnAction(ActionEvent actionEvent) throws IOException {
        if (aUserHasLoggedIn) {
            System.out.println("Condominium Management menu item is opened via 'System User Management (Edit/Remove)' menu bar");
            URL url = getClass().getResource("building-mgmt.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(this);
            GridPane condominiumUserManagementFXML = loader.load();
            borderPane.setCenter(condominiumUserManagementFXML);
            refresh(virtualDataBase.buildings.get(0));
            numberOfUnit.setText(Integer.toString(currentBuilding.getNumberOfUnit()));
            emptyUnit.setText(Integer.toString(currentBuilding.getEmptyUnit()));
            ownedUnit.setText(Integer.toString(currentBuilding.getOwnedUnit()));
            conBudget.setText(Double.toString(currentBuilding.getConBudget()));
            conDate.setText(currentBuilding.getConDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            completeDate.setText(currentBuilding.getCompleteDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            buildingSize.setText(currentBuilding.getSize());
        }
    }

}
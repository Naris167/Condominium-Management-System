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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
public class topController extends Controller {
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
    private Parent centerLoginFXML, centerMainFXML;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private boolean aUserHasLoggedIn;

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
        for(int i = 0; i < virtualDataBase.users.size(); i++ ){

        }
        return true;
    }

    @FXML
    protected void handleLoginButtonAction(ActionEvent event) throws IOException {
        if (Objects.equals(passwordPasswordField.getText(), "123")) {
//        if (verifyLogin(usernameTextField.getText(), passwordPasswordField.getText())) {
            aUserHasLoggedIn = true;
            String username = usernameTextField.getText();
            currentUserLabel.setText("Current User: " + username);
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
        // TODO: To be implemented
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
        usersTableView.getItems().remove(usersTableView.getSelectionModel().getSelectedItem());
        // Deleting user from data model goes here
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
     * This is the menu and controller for "user CRUD"
     */


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

}
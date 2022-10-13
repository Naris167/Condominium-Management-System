package org.stamford;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginController {
    @FXML
    private Label currentUserLabel;
    @FXML
    private Label systemMsgLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField displayTextField;
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        System.out.println("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");

    // myVBox.setSpacing(10);
    // String javaVersion = System.getProperty("java.version");
    // String javafxVersion = System.getProperty("javafx.version");
    // label.setText("Hello, JavaFX " + javafxVersion +
    // "\nRunning on Java " + javaVersion + ".");
    }
    @FXML protected void handleLoginButtonAction(ActionEvent event) throws IOException {
        if (Objects.equals(passwordPasswordField.getText(), "123")) {
            User user = new User();
//            UserGenerator userGenerator = new UserGenerator();
//            user.setID(1);
//            userGenerator.next();
            user.setName(usernameTextField.getText());
            mainApp.getMainApplication().setCurrentUser(user);
            // switch to main scene
            parent = FXMLLoader.load(getClass().getResource("main.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Stamford-CMS - Main Menu");
            // Send signal to model: A new user has logged in.
            currentUserLabel.setText("Current User: " + usernameTextField.getText());
            systemMsgLabel.setText("User '" + usernameTextField.getText() + "' is authenticated successfully.");
        } else {
             systemMsgLabel.setText("Authentication failed, try again.");
        }
    }

    @FXML protected void handle1ButtonAction(ActionEvent event) throws IOException {
        displayTextField.setText("1");
    }

//    @FXML protected void handler(ActionEvent event) {
//        String password = passwordPasswordField.getText();
//        // use the read data...
//    }
//    @FXML protected void handler(ActionEvent event) {
//        currentUserLabel.setText("new String value");
//    }
}
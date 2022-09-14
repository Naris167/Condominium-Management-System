package org.stamford;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {

    @FXML
    private Label currentUserLabel;
    @FXML
    private Label systemMsgLabel;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public void initialize() {
        String name = mainApp.getMainApplication().getCurrentUser().getName();
        currentUserLabel.setText("Current User: " + name);
        systemMsgLabel.setText("User '" + name + "' is authenticated successfully.");
    }

    public void systemUserManagementOnAction(ActionEvent event) throws IOException {
        parent = FXMLLoader.load(getClass().getResource("user-mgmt.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Stamford-CMS - System User Management");
        stage.show();
    }

    public void condominiumManagementOnAction(ActionEvent event) throws IOException {
        // TODO: To be implemented
    }

    public void systemSettingOnAction(ActionEvent event) throws IOException {
        // TODO: To be implemented
    }

    public void logoutOnAction(ActionEvent event) throws IOException {
        // Set current user to no one
        User noUser = User.createNoUser();
        mainApp.getMainApplication().setCurrentUser(noUser);
        // Show login window
        parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Stamford-CMS - Login Menu");
    }


}

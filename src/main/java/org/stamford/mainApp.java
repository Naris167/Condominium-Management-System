package org.stamford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class mainApp extends Application {
    private static mainApp mainApplication;
    private CMSystem system;

    @Override
    public void init() {
        mainApplication = this;
        system = new CMSystem();
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Creating a Stack Pane
        StackPane pane = new StackPane();

        String myClass = getClass().toString();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

//        Label currentUserLabel = new Label("Current User: " + "None");
//        Label systemMsgLabel = new Label("You must login before using Stamford-CMS");
//
//        currentUserLabel.setId("currentUserLabel");
//        systemMsgLabel.setId("systemMsgLabel");
//        VBox vbox = new VBox(10);
//        vbox.getChildren().add(currentUserLabel);
//        vbox.getChildren().add(systemMsgLabel);

        // Create a new scene
        //Scene scene = new Scene(vbox);
        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//        primary stage is created by the platform (JavaFX) already
        stage.setTitle("Stamford-CMS - Login Menu");
        stage.setScene(scene);
        stage.show();
        System.out.println("login.fxml file URL is: " + this.getClass().getResource("login.fxml").toExternalForm());

    }
    public static void main(String[] args) {
        launch(args);
    }

    public static  mainApp getMainApplication(){
        return mainApplication;
    }

    public boolean setCurrentUser(User user){
        system.setCurrentUser(user);
        return true;
    }

    public User getCurrentUser(){
        return system.getCurrentUser();
    }
}
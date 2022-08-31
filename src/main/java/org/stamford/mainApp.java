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

public class mainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Creating a Stack Pane
        StackPane pane = new StackPane();

        String myClass = getClass().toString();
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

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
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        // primary stage is created by the platform (JavaFX) already
        stage.setTitle("Stamford-CMS V1.0");
        stage.setScene(scene);
        stage.show();
        System.out.println("scene.fxml file URL is: " + this.getClass().getResource("scene.fxml").toExternalForm());

    }
public static void main(String[] args) {
        launch(args);
    }
}
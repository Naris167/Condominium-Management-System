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
//        String myClass = getClass().toString();
//        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
//
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
//
//        stage.setTitle("JavaFX and Gradle");
//        stage.setScene(scene);
//        stage.show();

        //Creating a Stack Pane
        StackPane pane = new StackPane();

        Label currentUserLabel = new Label("Current User: " + "None");
        Label systemMsgLabel = new Label("You must login before using Stamford-CMS");
//        VBox vbox = new VBox(10); // 10 is spacing between vertical nodes
//        vbox.getChildren().add(currentUserLabel);
//        vbox.getChildren().add(systemMsgLabel);

//        pane.getChildren().add(vbox);

        pane.getChildren().add(currentUserLabel);
        pane.getChildren().add(systemMsgLabel);

        // Create a new scene
        Scene scene = new Scene(pane);

        // primary stage is created by the platform (JavaFX) already
        stage.setTitle("Stamford-CMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Reflection example:
//        try {
//            Class c = Class.forName("java.util.Iterator");
//            // Class c = Class.forName("java.util.Stack");
//            // Class c = Class.forName("java.util.ArrayList");
//            Method m[] = c.getDeclaredMethods();
//
//            for (int i = 0; i < m.length; i++)
//                System.out.println(m[i].toString());
//        }
//        catch (Throwable e) {
//            System.err.println(e);
//        }

        launch(args);
    }
}
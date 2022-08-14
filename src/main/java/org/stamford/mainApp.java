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
        String myClass = getClass().toString();
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Stamford-CMS");
        stage.setScene(scene);
        stage.show();
}
public static void main(String[] args) {
        launch(args);
    }
}
package org.stamford;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.reflect.Method;

public class mainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String myClass = getClass().toString();
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("JavaFX and Gradle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Reflection example:
        try {
            Class c = Class.forName("java.util.Iterator");
            // Class c = Class.forName("java.util.Stack");
            // Class c = Class.forName("java.util.ArrayList");
            Method m[] = c.getDeclaredMethods();

            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        }
        catch (Throwable e) {
            System.err.println(e);
        }

        launch(args);
    }
}
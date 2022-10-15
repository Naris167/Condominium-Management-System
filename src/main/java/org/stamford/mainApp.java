package org.stamford;

//import Week_9.CoffeeGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
        Parent root = FXMLLoader.load(getClass().getResource("top.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Stamford-CMS - Login Menu");
        stage.setScene(scene);
        stage.show();
        System.out.println("login.fxml file URL is: " + this.getClass().getResource("login.fxml").toExternalForm());

    }
    public static void main(String[] args) {
        virtualDataBase.initialize();
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
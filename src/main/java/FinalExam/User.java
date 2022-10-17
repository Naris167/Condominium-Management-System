package org.stamford;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class User extends Application {

    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data = FXCollections.observableArrayList(
                    new Person("1001", "ehsan", "123"),
                    new Person("1002", "kiwi", "456"),
                    new Person("1003", "apple", "789")
            );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("ITE222 Final Exam Question 2");
        stage.setWidth(450);
        stage.setHeight(230);

        final Label label = new Label("ITE222 Final Exam Question 2");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setMaxHeight(125);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory( new PropertyValueFactory<Person, String>("ID"));

        TableColumn usernameCol = new TableColumn("Username");
        usernameCol.setMinWidth(100);
        usernameCol.setCellValueFactory( new PropertyValueFactory<Person, String>("Username"));

        TableColumn passwordCol = new TableColumn("Password");
        passwordCol.setMinWidth(200);
        passwordCol.setCellValueFactory( new PropertyValueFactory<Person, String>("Password"));

        table.setItems(data);
        table.getColumns().addAll(idCol, usernameCol, passwordCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty ID;
        private final SimpleStringProperty Username;
        private final SimpleStringProperty Password;

        private Person(String ID, String Username, String Password) {
            this.ID = new SimpleStringProperty(ID);
            this.Username = new SimpleStringProperty(Username);
            this.Password = new SimpleStringProperty(Password);
        }

        public String getID() {
            return ID.get();
        }

        public void setID(String fName) {
            ID.set(fName);
        }

        public String getUsername() {
            return Username.get();
        }

        public void setUsername(String fName) {
            Username.set(fName);
        }

        public String getPassword() {
            return Password.get();
        }

        public void setPassword(String fName) {
            Password.set(fName);
        }
    }
}

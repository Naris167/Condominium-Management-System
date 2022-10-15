package org.stamford;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class virtualDataBase {
    public static User currentUser;
    public static ObservableList<User> users;
    public static int userIDCounter = 0;
    public static void initialize() {
        // populate user table with system users
        // We don’t have a database yet, so we
        // have to create few dummy users.
        currentUser = new User();
        users = FXCollections.observableArrayList();

        //Admin user (my user)
        UserGenerator.increaseCounter();
        User naris = new User();
        naris.setName("Naris");
        naris.setSurname("Pornjirawittayakul");
        naris.setEmail("2106010007@students.stamford.edu");
        naris.setPassword("1234");
        naris.setRole("Administrator");
        naris.setBirthDate(LocalDate.of(2003, 4, 12));
        users.add(naris);

        //Dummy users
        UserGenerator userGenerator = new UserGenerator();
        for (int i = 0; i < 30; i++) {
            users.add(userGenerator.next());
        }

    }

    public static void increaseID() {
        userIDCounter++;
    }
}

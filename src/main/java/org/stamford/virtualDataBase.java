package org.stamford;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class virtualDataBase {
    public static User currentUser;
    public static ObservableList<User> users;
    public static int userIDCounter = 0;

    public static Building currentBuilding;
    public static ObservableList<Building> buildings;
    public static int buildingIDCounter = 0;

    public static void initialize() {
        // populate user table with system users
        // We don’t have a database yet, so we
        // have to create few dummy users.
        currentUser = new User();
        users = FXCollections.observableArrayList();
        currentBuilding = new Building();
        buildings = FXCollections.observableArrayList();

        //Admin user (my user)
        UserGenerator.increaseCounter();
        User naris = new User();
        naris.setName("Naris");
        naris.setSurname("Pornjirawittayakul");
        naris.setEmail("2106010007@students.stamford.edu");
        naris.setPassword("123");
        naris.setRole("Administrator");
        naris.setBirthDate(LocalDate.of(2003, 4, 12));
        users.add(naris);

        //Dummy users
        UserGenerator userGenerator = new UserGenerator();
        for (int i = 0; i < 30; i++) {
            users.add(userGenerator.next());
        }
        //Dummy buildings
        BuildingGenerator buildingGenerator = new BuildingGenerator();
        for (int j = 0; j < 30; j++) {
            buildings.add(buildingGenerator.next());
        }

//    public static void increaseID() {
//        userIDCounter++;
//    }
    }
}

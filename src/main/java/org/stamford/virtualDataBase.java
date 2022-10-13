package org.stamford;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class virtualDataBase {
    public static User currentUser;
    public static ObservableList<User> users;
    public static int userIDCounter = 0;
    public static void initialize() {
        currentUser = new User();
        // populate user table with system users
        // We don’t have a database yet, so we
        // have to create few dummy users.
//        User user1 = new User(
//                "Ehsan",
//                "Ali",
//                "ehsan.ali@stamford.edu",
//                "pass123",
//                LocalDate.of(1980, 1, 1)
//        );
//        user1.setID(1);
//
//        User user2 = new User(
//                "Sara",
//                "Ali",
//                "sara.ali@stamford.edu",
//                "sarapass123",
//                LocalDate.of(1990, 2, 3)
//        );
//        user2.setID(2);
//
//        User user3 = new User("Arash",
//                "Ghasemi",
//                "arash.ghasemi@gmail.com",
//                "arash123",
//                LocalDate.of(1981, 5, 6)
//        );
//        user3.setID(3);
//
//        userList.users = FXCollections.observableArrayList(
//                user1, user2, user3
//        );
//        for (int i = 1; i < 20; i++) {
//            User user = new User(
//                    "Arash" + i,
//                    "Ghasemi" + i,
//                    "arash.ghasemi" + i + "@gmail.com",
//                    "arash123" + i,
//                    LocalDate.of(1981, 5, i)
//            );
//            user.setID(i + 3);
//            userList.users.add(user);
//        }

        users = FXCollections.observableArrayList();
        UserGenerator userGenerator = new UserGenerator();
        for (int i = 0; i < 30; i++) {
//            increaseID();
            users.add(userGenerator.next());
        }

    }
    public static void increaseID() {
        userIDCounter++;
    }
}

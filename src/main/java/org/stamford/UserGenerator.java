package org.stamford;

import java.time.LocalDate;

public class UserGenerator implements Generator<User> {
    public static int counter = 0;
    private String[] roleList = {"Resident", "Guest"};
    public static void increaseCounter(){
        counter++;
    }

    @Override
    public User next() {
        try {
            increaseCounter();
            User user = new User();
            user.setName("user-" + user.getID());
            user.setSurname("surname-" + user.getID());
            user.setEmail("email-" + user.getID() + "@stamford.org");
            user.setPassword("password-" + user.getID());
            user.setRole(roleList[(user.getID() % 2)]);
            // generating random day between 1 to 27
            int day = (user.getID() % 28) + 1;
            user.setBirthDate(LocalDate.of(1980, 1, day));
            return user;
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
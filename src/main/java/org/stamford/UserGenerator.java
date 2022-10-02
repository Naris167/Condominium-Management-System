package org.stamford;

import java.time.LocalDate;
public class UserGenerator implements Generator<User> {
    @Override
    public User next() {
        try {
            User user = new User();
            user.setName("user-" + user.getID());
            user.setSurname("surname-" + user.getID());
            user.setEmail("email-" + user.getID() + "@stamford.org");
            user.setPassword("password-" + user.getID());
// generating random day between 1 to 27
            int day = (user.getID() % 28) + 1;
            user.setBirthDate(LocalDate.of(1980, 1, day));
            return user;
// Report programmer errors at run time:
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
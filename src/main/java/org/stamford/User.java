package org.stamford;

import java.time.LocalDate;

public class User extends Person{
    private int ID;
    private String email;
    private String password;
    public User () {
        super(); // call the superclass default constructor
        this.ID = 0;
        this.email = "";
        this.password = "";
        //this.selected = new SimpleBooleanProperty(false);
    }
    public User(String name, String surname, String email, String password, LocalDate birthdate) {
        super(name, surname, birthdate);
        this.ID = 0;
        this.email = email;
        this.password = password;
        //this.selected = new SimpleBooleanProperty(false);
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // factory methods
    public static User createNoUser() {
        User noUser = new User();
        noUser.setID(0);
        noUser.setPassword("");
        return noUser;
    }
}

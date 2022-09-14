package org.stamford;

public class CMSystem {
    private User currentUser;
    public CMSystem(){
        currentUser = User.createNoUser();
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(User currentUser){
        this.currentUser = currentUser;
    }
}

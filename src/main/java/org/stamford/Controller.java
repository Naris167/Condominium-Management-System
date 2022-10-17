package org.stamford;

public abstract class Controller {
    abstract void notifyUserUpdate(User user);
    abstract void notifyBuildingUpdate(Building building);
}

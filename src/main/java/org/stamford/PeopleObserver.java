package org.stamford;

import java.util.Observable;
import java.util.Observer;

// Onserver is an interface
public class PeopleObserver implements Observer {
     private String name;
     public PeopleObserver() {
         super();
     }
    public PeopleObserver(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " got " + ((Integer) arg).intValue() + " winks");
    }
}

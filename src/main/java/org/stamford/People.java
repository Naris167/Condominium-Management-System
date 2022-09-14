package org.stamford;

import java.util.Observable;
// Observable is a class
public class People extends Observable {
    private String name;
    public People() {
        super();
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void wink(int count) {
        setChanged();
        notifyObservers(count);
    }
}

//package org.stamford;
//import java.util.Random;
//
//public class Main {
//    public static void main(String[] args) {
//        People ehsan = new People("Ehsan");
//        PeopleObserver stu1 = new PeopleObserver("Student1");
//        PeopleObserver stu2 = new PeopleObserver("student2");
//        PeopleObserver stu3 = new PeopleObserver("Student3");
//        ehsan.addObserver(stu1);
//        ehsan.addObserver(stu2);
//        ehsan.addObserver(stu3);
//        System.out.println("There are " + ehsan.countObservers() + " observers of " + ehsan.getName());
//
//        Random r = new Random();
//        // generate a random number of winks
//        ehsan.wink(r.nextInt(10));
//    }
//}
package Week_9;

// Coffee.java

import java.util.Iterator;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}




//
//
//
//
//    public Iterator<Coffee> iterator() {
//
//        return new CoffeeIterator();
//
//    }




package Week_4;

public interface IntSequence { //Week4 Task 1.3.1 Declaring an Interface
    //1.3.8 Static, Default, and Private Methods

//    boolean hasNext();
    default boolean hasNext() { //Default Methods
        return true;
    }
    // By default, sequences are infinite
    int next();
    static IntSequence digitsOf(int n) { //Static Methods
        return new DigitSequence(n);
    }

}

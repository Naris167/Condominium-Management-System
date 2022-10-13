package Week_9;

public class GenericMethods {
    // A generic method that prints the name of class passed to it via parameter
    public <T, T2, T3> void method(T x, T2 y, T3 z) {
        System.out.print(x.getClass().getName() + " - ");
        System.out.print(y.getClass().getName() + " - ");
        System.out.print(z.getClass().getName() + "\n");
    }
}

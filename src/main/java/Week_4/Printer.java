package Week_4;

public class Printer extends RealPrinter {
    // the "delegator"
    RealPrinter p = new RealPrinter();

    // create the delegate
    void printDelegation() {
        p.print(); // delegation
    }

    void printInheriting () {
        super.print(); // inside calling method of parent
    }
}

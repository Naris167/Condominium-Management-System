package Week_4;

public class Private_Methods {
    private void print() {
        System.out.println("The Private Method can only be printed in the defining Class");
    }

    public void getPrint() {
        print();
    }
}

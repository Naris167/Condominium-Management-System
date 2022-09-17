package Week_4;

public class A {
    protected int counter = 1;
    public void loop() {
        System.out.println("Looping " + counter + " times");
        counter++;
        this.loop();
    }
}

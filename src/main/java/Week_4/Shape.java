package Week_4;

abstract class Shape {
    //1.4.4 Data Abstraction
    //1.4.6 Inheritance
    // If you set this to private then Cicrcle and Rectangle
    // classes cannot access it.
    // If you set it to public then it is universally accessible which
    // is also a bad thing.
    protected String color;
    // these are abstract methods
    protected abstract double area();
    public abstract String toString();
    // abstract class can have a constructor
    public Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }
    // this is a concrete method
    public String getColor() {
        return color;
    }
}

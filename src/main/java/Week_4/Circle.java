package Week_4;

public class Circle extends Shape {
    //1.4.4 Data Abstraction
    //1.4.6 Inheritance
    public double radius;
    public Circle(String color, double radius) {
        // calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }
    // Providing a body for abstract area method
    // Notice that it is protected
    @Override
    protected double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle color is " + super.color + "and area is : " + area();
    }
}

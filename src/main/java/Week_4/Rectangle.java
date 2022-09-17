package Week_4;

class Rectangle extends Shape {
    //1.4.4 Data Abstraction
    //1.4.6 Inheritance
    public double length;
    public double width;
    public Rectangle(String color, double length, double width) {
        // calling Shape constructor
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }
    // Providing a body for abstract area method
    // Notice that it is protected
    @Override
    protected double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.color + "and area is : " + area();
    }
}

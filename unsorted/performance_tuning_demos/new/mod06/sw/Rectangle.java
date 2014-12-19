// Rectangle class
public class Rectangle implements Shape {

    final private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    private Rectangle(){length = width = 0;}

    public double area() {
        return length * width;
    }
}

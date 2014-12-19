// RightTriangle class
public class RightTriangle implements Shape {

    final private double base, height;

    public RightTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    private RightTriangle(){base = height = 0;}

    public double area() {
        return .5 * base * height;
    }
}

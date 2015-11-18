// RightTriangle class
public class RightTriangle implements Shape {
	private final double base;
	private final double height;

	public RightTriangle(double ibase, double iheight) {
		base = ibase;
		height = iheight;
	}

	private RightTriangle() {
		base = height = 0;
	}

	public double area() {
		return .5 * base * height;
	}
}

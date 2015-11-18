public class Rectangle implements Shape {
	private final double length;
	private final double width;

	public Rectangle(double ilength, double iwidth) {
		length = ilength;
		width = iwidth;
	}

	private Rectangle() {
		length = width = 0;
	}

	public double area() {
		return length * width;
	}
}

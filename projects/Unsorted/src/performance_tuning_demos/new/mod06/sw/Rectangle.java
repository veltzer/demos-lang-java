public class Rectangle implements Shape {
	final private double length;
	final private double width;

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

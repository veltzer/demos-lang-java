// Square class
public class Square implements Shape {
	private final double side;

	public Square(double iside) {
		side = iside;
	}
	private Square() {
		side = 0;
	}
	public double area() {
		return side * side;
	}
}

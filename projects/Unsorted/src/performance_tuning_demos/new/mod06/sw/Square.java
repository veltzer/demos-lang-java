// Square class
public class Square implements Shape {

	final private double side;

	public Square(double side) {
		this.side = side;
	}

	private Square(){side = 0;}

	public double area() {
		return side * side;
	}
}

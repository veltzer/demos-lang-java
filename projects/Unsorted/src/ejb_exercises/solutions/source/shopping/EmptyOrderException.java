package ejb_exercises.solutions.source.shopping;

@SuppressWarnings("serial")
public class EmptyOrderException extends Exception {
	public EmptyOrderException(String msg) {
		super(msg);
	}
}
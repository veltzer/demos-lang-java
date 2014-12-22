package ejb.exercises.exercises.source.shopping;

@SuppressWarnings("serial")
public class EmptyOrderException extends Exception {
	public EmptyOrderException(String msg) {
		super(msg);
	}
}

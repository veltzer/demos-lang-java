package ejbwl.exercises.source.shopping;

@SuppressWarnings("serial")
public class EmptyOrderException extends RuntimeException {
	public EmptyOrderException(String msg) {
		super(msg);
	}
}

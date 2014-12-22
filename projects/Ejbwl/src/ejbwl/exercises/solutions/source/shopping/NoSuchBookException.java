package ejbwl.exercises.solutions.source.shopping;

@SuppressWarnings("serial")
public class NoSuchBookException extends RuntimeException {
	public NoSuchBookException(String msg) {
		super(msg);
	}
}

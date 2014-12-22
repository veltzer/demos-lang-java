package ejb.exercises.exercises.source.shopping;

@SuppressWarnings("serial")
public class NoSuchBookException extends RuntimeException {
	public NoSuchBookException(String msg) {
		super(msg);
	}
}

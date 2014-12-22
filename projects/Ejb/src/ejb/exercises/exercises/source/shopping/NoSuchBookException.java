package ejb.exercises.exercises.source.shopping;

@SuppressWarnings("serial")
public class NoSuchBookException extends Exception {
	public NoSuchBookException(String msg) {
		super(msg);
	}
}

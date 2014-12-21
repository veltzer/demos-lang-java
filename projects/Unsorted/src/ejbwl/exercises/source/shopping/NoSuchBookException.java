package ejbwl.exercises.source.shopping;

public class NoSuchBookException extends Exception {
	public NoSuchBookException(String msg) {
		super(msg);
	}
}

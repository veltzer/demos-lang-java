package ejbwl.exercises.source.bookstore;

public class InvalidBookDataException extends Exception {
	public InvalidBookDataException(String msg) {
		super(msg);
	}
	public InvalidBookDataException(String msg, Throwable ex) {
		super(msg, ex);
	}
}

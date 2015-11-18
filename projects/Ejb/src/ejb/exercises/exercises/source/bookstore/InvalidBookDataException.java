package ejb.exercises.exercises.source.bookstore;

@SuppressWarnings("serial")
public class InvalidBookDataException extends RuntimeException {
	public InvalidBookDataException(String msg) {
		super(msg);
	}

	public InvalidBookDataException(String msg, Throwable ex) {
		super(msg, ex);
	}
}

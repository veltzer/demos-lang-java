package ejb_exercises.exercises.source.bookstore;

@SuppressWarnings("serial")
public class InvalidBookDataException extends Exception {
	public InvalidBookDataException(String msg) {
		super(msg);
	}

// If using java 1.4 or heigher, uncomment the following:
//	public InvalidBookDataException(String msg, Throwable ex) {
//		super(msg,ex);
//	}
}

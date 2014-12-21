package ejb.exercises.exercises.source.shopping;

@SuppressWarnings("serial")
public class NoSuchBookException extends Exception {
	public NoSuchBookException(String msg){
		super(msg);
	}
	// is using java1.4 or higher, create a consturctor with a CAUSE.
}

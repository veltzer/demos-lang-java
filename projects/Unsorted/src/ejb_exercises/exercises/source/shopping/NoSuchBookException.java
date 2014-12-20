package shopping;

public class NoSuchBookException extends Exception {
	public NoSuchBookException(String msg){
		super(msg);
	}
	// is using java1.4 or higher, create a consturctor with a CAUSE.
}

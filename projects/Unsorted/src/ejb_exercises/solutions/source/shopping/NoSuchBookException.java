package ejb_exercises.solutions.source.shopping;

@SuppressWarnings("serial")
public class NoSuchBookException extends Exception{
	public NoSuchBookException(String msg){
		super(msg);
	}
	// is using java1.4 or heigher, create a consturctor with a CAUSE.
}

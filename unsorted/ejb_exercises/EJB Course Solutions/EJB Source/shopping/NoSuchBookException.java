/*
 * Created on Feb 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package shopping;

/**
 * @author pel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NoSuchBookException extends Exception{
	public NoSuchBookException(String msg){
		super(msg);
	}
	
	// is using java1.4 or heigher, create a consturctor with a CAUSE.

}

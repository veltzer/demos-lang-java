/*
 * Created on Feb 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package bookstore;

public class InvalidBookDataException extends Exception{
	public InvalidBookDataException(String msg){
		super(msg);
	}

// If using java 1.4 or heigher, uncomment the following:	
//	public InvalidBookDataException(String msg, Throwable ex){
//		super(msg,ex);
//	}	
}

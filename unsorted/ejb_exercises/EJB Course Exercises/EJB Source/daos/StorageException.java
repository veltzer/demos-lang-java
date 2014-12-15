/*
 * Created on Feb 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package daos;

/**
 * This exception is thrown by BookStoreDAO when errors are encountered. <br>
 * This approach is preferrable to directly throwing SQL exceptions, 
 * since DAO's may use non-sql persistance. 
 */
public class StorageException extends RuntimeException{
	public StorageException(String msg){
		super(msg);
	}
	
// if you're working with java 1.4 or heigher, uncomment the following:
//	public StorageException(String msg, Throwable cause){
//		super(msg,cause);
//	}
	
}

package ejb_exercises.exercises.source.daos;

/**
 * This exception is thrown by BookStoreDAO when errors are encountered. <br>
 * This approach is preferrable to directly throwing SQL exceptions,
 * since DAO's may use non-sql persistance.
 */
@SuppressWarnings("serial")
public class StorageException extends RuntimeException{
	public StorageException(String msg){
		super(msg);
	}
// if you're working with java 1.4 or heigher, uncomment the following:
//	public StorageException(String msg, Throwable cause){
//		super(msg,cause);
//	}
}

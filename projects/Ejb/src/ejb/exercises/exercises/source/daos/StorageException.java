package ejb.exercises.exercises.source.daos;

/**
 * This exception is thrown by BookStoreDAO when errors are encountered. This
 * approach is preferrable to directly throwing SQL exceptions, since DAO's may
 * use non-sql persistance.
 */
@SuppressWarnings("serial")
public class StorageException extends RuntimeException {
	public StorageException(String msg) {
		super(msg);
	}

	public StorageException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

package ejb.exercises.solutions.source.bookstore;

import javax.ejb.CreateException;
import java.rmi.RemoteException;
import javax.ejb.EJBHome;

/**
 * Home interface for Enterprise Bean: BookstoreAdmin
 */
public interface BookstoreAdminHome extends EJBHome {
	/**
	 * Creates a default instance of Session Bean: BookstoreAdmin
	 */
	BookstoreAdmin create() throws CreateException, RemoteException;
}

package ejbwl.exercises.solutions.source.bookstore;

import javax.ejb.CreateException;
import java.rmi.RemoteException;

/**
 * Home interface for Enterprise Bean: BookstoreAdmin
 */
public interface BookstoreAdminHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: BookstoreAdmin
	 */
	BookstoreAdmin create() throws CreateException, RemoteException;
}

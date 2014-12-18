package bookstore;
/**
 * Home interface for Enterprise Bean: BookstoreAdmin
 */
public interface BookstoreAdminHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: BookstoreAdmin
	 */
	public BookstoreAdmin create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

package ejb.exercises.solutions.source.shopping;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

/**
 * Home interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCartHome extends EJBHome {
	/**
	 * Creates a default instance of Session Bean: ShoppingCart
	 */
	ShoppingCart create(String customerId) throws CreateException, RemoteException;
}

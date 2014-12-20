package ejb_exercises.solutions.source.shopping;

import javax.ejb.EJBHome;

/**
 * Home interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCartHome extends EJBHome {
	/**
	 * Creates a default instance of Session Bean: ShoppingCart
	 */
	public ShoppingCart create(String customerId)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
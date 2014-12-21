package ejb.exercises.solutions.source.shopping;

import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJBObject;

/**
 * Remote interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCart extends EJBObject {
	String getCustomerId() throws RemoteException;
	void addToCart(String title) throws RemoteException;
	List<String> getTitlesInCart() throws RemoteException;
	String placeOrder() throws RemoteException;
}

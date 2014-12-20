package ejb_exercises.solutions.source.shopping;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Remote interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCart extends javax.ejb.EJBObject {
	String getCustomerId() throws RemoteException;
	void addToCart(String title) throws NoSuchBookException, RemoteException;
	List<String> getTitlesInCart() throws RemoteException;
	String placeOrder() throws EmptyOrderException, RemoteException;
}

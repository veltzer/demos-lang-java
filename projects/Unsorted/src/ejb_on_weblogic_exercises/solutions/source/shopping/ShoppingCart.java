package shopping;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Remote interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCart extends javax.ejb.EJBObject {
	String getCustomerId() throws RemoteException;
	void addToCart(String title) throws NoSuchBookException, RemoteException;
	List getTitlesInCart() throws RemoteException;
	String placeOrder() throws EmptyOrderException, RemoteException;
}

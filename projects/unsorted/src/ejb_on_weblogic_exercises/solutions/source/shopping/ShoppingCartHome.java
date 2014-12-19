package shopping;
/**
 * Home interface for Enterprise Bean: ShoppingCart
 */
public interface ShoppingCartHome extends javax.ejb.EJBHome {
	/**
	 * Creates a default instance of Session Bean: ShoppingCart
	 */
	public shopping.ShoppingCart create(String customerId)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

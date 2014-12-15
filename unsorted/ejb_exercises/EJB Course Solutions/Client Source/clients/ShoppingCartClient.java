package clients;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import shopping.ShoppingCart;
import shopping.ShoppingCartHome;

/**
 * A simple client for testing ShoppingCart. <br>
 * 
 * This client would: <ul>
 * <li> Obtain a stub to a shopping cart
 * <li> Add some book titles to it
 * <li> Place the order (Receiving a confimration id)
 */
public class ShoppingCartClient {

	public static void main(String[] args) throws Exception {
		// Lookup:
		InitialContext ictx = new InitialContext();
		Object obj = ictx.lookup("ejb/shopping/ShoppingCartHome");
		ShoppingCartHome home =
			(ShoppingCartHome) PortableRemoteObject.narrow(
				obj,
				ShoppingCartHome.class);
		ShoppingCart cart = home.create("111");

		// Add books (Assuming these books are in the DB ! 
		// you may add them using BookStoreAdming).
		cart.addToCart("Lord of the Rings");
		cart.addToCart("The Truth");

		// view books in cart:
		System.out.println("Books currently in cart:");
		System.out.println(cart.getTitlesInCart());

		// place order:
		String confirmedOrderId = cart.placeOrder();
		System.out.println("Placed order # " + confirmedOrderId);

		// release resources:
		cart.remove();

	}
}

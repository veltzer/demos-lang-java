package ejbwl.exercises.solutions.source.shopping;

import javax.ejb.EJBHome;

public interface ShoppingCartHome extends EJBHome {
	shopping.ShoppingCart create(String customerId);
}

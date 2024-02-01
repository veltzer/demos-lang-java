package ejbwl.exercises.solutions.source.shopping;

import javax.ejb.EJBHome;

public interface ShoppingCartHome extends EJBHome {
	ShoppingCart create(String customerId);
}

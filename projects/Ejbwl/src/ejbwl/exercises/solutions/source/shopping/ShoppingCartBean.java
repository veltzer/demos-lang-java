package ejbwl.exercises.solutions.source.shopping;

import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import javax.ejb.SessionContext;
import javax.ejb.SessionBean;

import ejbwl.exercises.solutions.source.daos.BookstoreDAO;
import ejbwl.exercises.solutions.source.daos.BookstoreDaoFactory;
import ejbwl.exercises.solutions.source.dtos.BookDTO;

@SuppressWarnings("serial")
public class ShoppingCartBean implements SessionBean {
	private BookstoreDAO dao;
	private List<String> bookTitles;
	private String customerId;

	public void setSessionContext(SessionContext ctx) {
		System.out.println(getClass().getName() + ".setSessionContext() was invoked...");
	}
	public void ejbCreate(String icustomerId) {
		System.out.println(getClass().getName() + ".ejbCreate() was invoked...");
		customerId = icustomerId;
		bookTitles = new LinkedList<String>();
		// Note initialization must be done in create(). Do not
		// initialize bookTitles at declaration !

		try {
			InitialContext ictx = new InitialContext();
			Object obj = ictx.lookup("jdbc/ds1");
			DataSource dataSrouce = (DataSource) PortableRemoteObject.narrow(obj, DataSource.class);
			dao = BookstoreDaoFactory.getDAO(dataSrouce);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void ejbActivate() {
		System.out.println(this.getClass().getName() + ".ejbActivate() was invoked...");
	}
	public void ejbPassivate() {
		System.out.println(this.getClass().getName() + ".ejbPassivate() was invoked...");
	}
	public void ejbRemove() {
		System.out.println(this.getClass().getName() + ".ejbRemove() was invoked...");
		bookTitles = null;
	}
	public String getCustomerId() {
		return customerId;
	}

	public void addToCart(String bookTitle) {
		BookDTO foundBook = dao.selectBook(bookTitle);
		if (foundBook == null) {
			throw new NoSuchBookException("No such book:" + bookTitle);
		}
		bookTitles.add(bookTitle);
	}

	public List<String> getTitlesInCart() {
		return bookTitles;
	}

	public String placeOrder() {
		if (bookTitles.size() == 0) {
			throw new EmptyOrderException("Order must include some items");
		}

		// Generate an order id. Due to time limitations, we shall settle
		// for a random number, assuming it will be unique.
		// Other strategies would be:
		// - using a database record
		// - vender-specific sequential numbers (requires jdbc 3.0 !)
		// - stored procedure
		String orderId = "" + ((int) Math.random() * 1000);

		long time = System.currentTimeMillis();
		dao.insertOrder(orderId, customerId, time, bookTitles);
		return orderId;
	}
}

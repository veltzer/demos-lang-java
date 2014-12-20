package ejb_exercises.solutions.source.shopping;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import ejb_exercises.solutions.source.daos.BookstoreDAO;
import ejb_exercises.solutions.source.daos.BookstoreDaoFactory;
import ejb_exercises.solutions.source.dtos.BookDTO;

/**
 * Bean implementation class for Enterprise Bean: ShoppingCart
 */
@SuppressWarnings("serial")
public class ShoppingCartBean implements javax.ejb.SessionBean {
	private BookstoreDAO dao;

	private List<String> bookTitles;
	private String customerId;

	/**
		* setSessionContext
		*/
	public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
	}
	/**
		* ejbCreate
		*/
	public void ejbCreate(String customerId) throws javax.ejb.CreateException
	{
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
		this.customerId = customerId;
		bookTitles = new LinkedList<String>();
		// Note initialization must be done in create(). Do not
		// initialize bookTitles at declaration !

		try {
			InitialContext ictx = new InitialContext();
			Object obj = ictx.lookup("jdbc/ds1");
			DataSource dataSrouce = (DataSource) PortableRemoteObject.narrow(obj,DataSource.class);
			dao = BookstoreDaoFactory.getDAO(dataSrouce);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CreateException("Cannot create bean. "+ex);
		}
	}

	/**
		* ejbActivate
		*/
	public void ejbActivate()
	{
		System.out.println(this.getClass().getName() + ".ejbActivate() was invoked...");
	}
	/**
		* ejbPassivate
		*/
	public void ejbPassivate()
	{
		System.out.println(this.getClass().getName() + ".ejbPassivate() was invoked...");
	}
	/**
		* ejbRemove
		*/
	public void ejbRemove() {
		System.out.println(this.getClass().getName() + ".ejbRemove() was invoked...");
		bookTitles = null;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void addToCart(String bookTitle) throws NoSuchBookException {
		BookDTO foundBook = dao.selectBook(bookTitle);
		if (foundBook == null)
			throw new NoSuchBookException("No such book:" + bookTitle);
		bookTitles.add(bookTitle);
	}

	public List<String> getTitlesInCart() {
		return bookTitles;
	}

	public String placeOrder() throws EmptyOrderException {
		if (bookTitles.size() == 0)
			throw new EmptyOrderException("Order must include some items");

		// Generate an order id. Due to time limitations, we shall settle
		// for a random number, assuming it will be unique.
		// Other strategies would be:
		// - using a database record
		// - vender-specific sequential numbers (requires jdbc 3.0 !)
		// - stored procedure
		String orderId = "" + ((int)Math.random()*1000);

		long time = System.currentTimeMillis();
		dao.insertOrder(orderId, customerId, time, bookTitles);
		return orderId;
	}

}

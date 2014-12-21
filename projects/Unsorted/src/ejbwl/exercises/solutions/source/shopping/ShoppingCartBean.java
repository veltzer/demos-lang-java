package ejbwl.exercises.solutions.source.shopping;
import java.util.*;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import daos.BookstoreDAO;
import daos.BookstoreDaoFactory;
import dtos.BookDTO;

/**
 * Bean implementation class for Enterprise Bean: ShoppingCart
 */
public class ShoppingCartBean implements javax.ejb.SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	private BookstoreDAO dao;

	private List bookTitles;
	private String customerId;

	/**
		* setSessionContext
		*/
	public void setSessionContext(javax.ejb.SessionContext ctx)
	{
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
		mySessionCtx = ctx;
	}
	/**
		* ejbCreate
		*/
	public void ejbCreate(String customerId) throws javax.ejb.CreateException
	{
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
		this.customerId = customerId;
		bookTitles = new LinkedList();
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

	public List getTitlesInCart() {
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

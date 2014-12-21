package ejb.exercises.solutions.source.bookstore;

//import java.util.*;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import javax.ejb.SessionBean;

/**
 * Bean implementation class for Enterprise Bean: BookstoreAdmin
 *
 * (For details, please consult the documentation of
 * interface BookStoreAdmin)
 */
public class BookstoreAdminBean implements SessionBean {
	private javax.ejb.SessionContext mySessionCtx;
	private BookstoreDAO dao;
	private BookHome bookHome;

	/**
 	 * Settign session context: <ul>
	 * <li> keep reference to session context
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
		mySessionCtx = ctx;
	}

	public void ejbCreate() throws javax.ejb.CreateException {
		//declare locals
		Object obj = null;
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
		try {
			InitialContext ictx = new InitialContext();
			obj = ictx.lookup("java:comp/env/jdbc/MyDS");
			DataSource dataSrouce = (DataSource) PortableRemoteObject.narrow(obj, DataSource.class);
			dao = BookstoreDaoFactory.getDAO(dataSrouce);
			obj = ictx.lookup("ejb/entity/BookLocalHome");
			bookHome = (BookHome) PortableRemoteObject.narrow(obj, BookHome.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CreateException("failed to create the bean. " + ex.getMessage());
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
	}

	/**
	* Adds a new book to inventory: <ul>
	* <li> Performs validity checks (e.g. quantity>=0)
	* <li> Uses DAO to store book into DB
	*
	* @param book
	* @throws InvalidBookDataException if book title is empty, or quantity is negative.
	*/
	public void addNewBook(BookDTO book) throws InvalidBookDataException {
		String title = book.getTitle();
		double price = book.getPrice();
		if (price < 0 || title == null || title.length() == 0) {
			throw new InvalidBookDataException(
				"Book price must by non-negative"
					+ "and title must be non-empty");
		}

		/*
		try
		{
			bookHome.create(title,book.getAuthor(),price);
		} catch (CreateException e) {
			throw new EJBException(e);
		}
		*/

		dao.insertBook(title, book.getAuthor(), book.getPrice());
	}

	/**
	* Adds a new customer to inventory (using DAO to make sure
	* record is persisted in the DB).
	*/
	public void addNewCustomer(CustomerDTO customer) {
		dao.insertCustomer(
			customer.getId(),
			customer.getName(),
			customer.getEmail(),
			customer.getAddress()
		);
	}

	/**
	* Returns a list of all books in inventory.
	* @return a list of BookDTO's
	*/
	public List showBooks() {
		// Perform a "select* from BOOKS" and store result into list:
		List result = dao.selectBooks();
		/*
		Collection books;
		try {
			books = bookHome.findAllBooks();
		} catch (FinderException e) {
			e.printStackTrace();
			return null;
		}
		List result = new ArrayList(books.size());
		Iterator it = books.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			result.add(new BookDTO(book.getTitle(),book.getAuthor(),book.getPrice()));
		}
		*/
		return result;
	}

	/**
	* Returns a list of all registered customers.
	* @return a list of CustomerDTO's
	*/
	public List showCustomers() {
		List customers = dao.selectCustomers();
		return customers;
	}
}

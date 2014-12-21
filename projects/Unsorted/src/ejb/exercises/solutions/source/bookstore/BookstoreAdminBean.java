package ejb.exercises.solutions.source.bookstore;

import java.util.List;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import javax.ejb.SessionBean;

import ejb.exercises.solutions.source.book.BookHome;
import ejb.exercises.solutions.source.daos.BookstoreDAO;
import ejb.exercises.solutions.source.daos.BookstoreDaoFactory;
import ejb.exercises.solutions.source.dtos.BookDTO;
import ejb.exercises.solutions.source.dtos.CustomerDTO;

/**
 * Bean implementation class for Enterprise Bean: BookstoreAdmin
 *
 * (For details, please consult the documentation of
 * interface BookStoreAdmin)
 */
@SuppressWarnings("serial")
public class BookstoreAdminBean implements SessionBean {
	private BookstoreDAO dao;
	/**
 	 * Setting session context: <ul>
	 * <li> keep reference to session context
	 */
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
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
			obj = (BookHome) PortableRemoteObject.narrow(obj, BookHome.class);
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
	public List<BookDTO> showBooks() {
		List<BookDTO> result = dao.selectBooks();
		return result;
	}

	/**
	* Returns a list of all registered customers.
	* @return a list of CustomerDTO's
	*/
	public List<CustomerDTO> showCustomers() {
		List<CustomerDTO> customers = dao.selectCustomers();
		return customers;
	}
}

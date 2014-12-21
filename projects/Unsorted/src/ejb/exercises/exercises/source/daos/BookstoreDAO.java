package ejb.exercises.exercises.source.daos;

import java.util.List;

import ejb.exercises.exercises.source.dtos.BookDTO;
import ejb.exercises.exercises.source.dtos.CustomerDTO;
import ejb.exercises.exercises.source.dtos.OrderDetailsDTO;

/**
 * Data Access Object for a book store. <br>
 * Includes methods such as:
 *
 * <ul>
 * <li> Adding a book to the DB
 * <li> Adding a customer to the DB
 * <li> Adding an order to the DB (where order may consist of several titles)
 * <li> Cancelling an order
 * <li> Obtaining a list of all books in the inventory
 * <li> Obtaining a list of all customers
 * <li> Locating book details (by title)
 * <li> Locating customer details (by ID)
 * <li> Locating order details (by order ID)
 *
 * </ul>
 *
 * Note: to obtain a concrete DAO, use a factory. Example: <br>
 *
 * InitialContex ictx=new InitialContext();
 * DataSource ds=(DataSource) ictx.lookup("jdbc/ds1");
 * BookstoreDAO dao=BookstoreDaoFactory.getDAO(ds);
 */
public interface BookstoreDAO {

	/**
	 * Insets a new book record. <br>
	 * This method does not allow duplicate keys (where title is
	 * assumed to be the key).
	 *
	 * @param title book's title (used as key, must be unique)
	 * @param author book's author
	 * @param quantity number of copies available in inventory
	 * @throws StorageException
	 */
	void insertBook(String title, String author, double price) throws StorageException;

	/**
	 * Returns all books in the inventory. <br>
	 * Return value is a list of BookDTO's.
	 *
	 * Note: this is a "disconnected" view - namely, list is obtained
	 * by reading the books table, loading it into memory, then closing
	 * the DB connection.
	 * @throws StorageException
	 */
	List<BookDTO> selectBooks() throws StorageException;

	/**
	 * Given a book title, returns book details.
	 * Returns null if no such book exists.
	 *
	 * @param orderId
	 * @throws StorageException
	 */
	BookDTO selectBook(String title) throws StorageException;

	/**
	 * Inserts a new customer record. <br>
	 * This method does not allow duplicate keys (where title is
	 * assumed to be the key).
	 *
	 * @param id the new customer's id (assumed to by unique)
	 * @param name the new customer's name (first+last, concatenated)
	 * @param email customer's email address
	 * @param address customer's shipping address
	 * @throws StorageException
	 */
	void insertCustomer(String id, String name, String email, String address) throws StorageException;

	/**
	 * Returns all customers currently registered. <br>
	 * Return value is a list of CustomerDTO's.
	 *
	 * Note: this is a "disconnected" view - namely, list is obtained
	 * by reading the customers table, loading it into memory, then closing
	 * the DB connection.
	 * @throws StorageException
	 */
	List<CustomerDTO> selectCustomers() throws StorageException;

	/**
	 * Given a custoemr id, returns customer details.
	 * Returns null if no such customer exists.
	 *
	 * @param customerId
	 * @throws StorageException
	 */
	CustomerDTO selectCustomer(String customerId) throws StorageException;

	/**
	 * Given an order ID, returns order details (including list of
	 * book titles).
	 * Returns null if no such order exists.
	 *
	 * @param orderId
	 * @throws StorageException
	 */
	OrderDetailsDTO selectOrder(String orderId) throws StorageException;

	/**
	 * Insets a new order into the database.
	 * This method does not allow duplicates- it will yield an error if
	 * a similar orderId already exists.
	 *
	 * @param orderId
	 * @param customerId
	 * @param timestamp
	 * @param bookTitles
	 * @throws StorageException
	 */
	void insertOrder(String orderId, String customerId, long timestamp, List<String> bookTitles ) throws StorageException;

	/**
	 * Cancels a given order. If no such order exists, this method will
	 * return "false".
	 *
	 * @param orderId the order to be cancelled.
	 * @return true-if order was found & cancelled, false-if order was not found.
	 * @throws StorageException
	 */
	boolean cancelOrder(String orderId) throws StorageException;
}

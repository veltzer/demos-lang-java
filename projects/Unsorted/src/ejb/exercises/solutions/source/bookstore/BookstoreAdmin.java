package ejb.exercises.solutions.source.bookstore;

import java.rmi.RemoteException;
import java.util.List;

import ejb.exercises.solutions.source.dtos.BookDTO;
import ejb.exercises.solutions.source.dtos.CustomerDTO;
import javax.ejb.EJBObject;

/**
 * Remote interface for Enterprise Bean: BookstoreAdmin
 * This bean is to be used by an administrator, for performing
 * actions such as:
 *
 * <ul>
 * <li> Adding a new book to inventory
 * <li> Adding a new customer to inventory
 * <li> Viewing all books in inventory or all registered customers
 * </ul>
 */
public interface BookstoreAdmin extends EJBObject {
	void addNewBook(BookDTO book) throws RemoteException;
	void addNewCustomer(CustomerDTO customer) throws RemoteException;
	List<BookDTO> showBooks() throws RemoteException;
	List<CustomerDTO> showCustomers() throws RemoteException;
}

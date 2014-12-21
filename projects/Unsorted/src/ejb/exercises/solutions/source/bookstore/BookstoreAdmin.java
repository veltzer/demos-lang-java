package ejb.exercises.solutions.source.bookstore;

import java.rmi.RemoteException;

import dtos.BookDTO;
import dtos.CustomerDTO;
import java.util.*;

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
 *
 */
public interface BookstoreAdmin extends javax.ejb.EJBObject {
	void addNewBook(BookDTO book) throws InvalidBookDataException, RemoteException;
	void addNewCustomer(CustomerDTO customer) throws RemoteException;
	List showBooks() throws RemoteException;
	List showCustomers() throws RemoteException;
}

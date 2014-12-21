package ejb.exercises.solutions.source.book;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface BookHome extends EJBLocalHome {
	Book create(String title, String author, double price) throws CreateException;
	Book findByPrimaryKey(String bookTitle) throws FinderException;
	Collection<Book> findAllBooks() throws FinderException;
}

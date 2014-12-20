package ejb_exercises.solutions.source.book;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

public interface BookHome extends EJBLocalHome {
	public Book create(String title,String author,double price) throws CreateException;
	public Book findByPrimaryKey(String bookTitle) throws FinderException;
	public Collection<Book> findAllBooks() throws FinderException;
}
package ejbwl.exercises.solutions.source.bookcmp;

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface BookHome extends EJBLocalHome {
	Book create(String title, String author, double price) throws CreateException;
	Book findByPrimaryKey(String bookTitle) throws FinderException;
}

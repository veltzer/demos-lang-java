package ejb.exercises.solutions.source.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import javax.ejb.RemoveException;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ejb.exercises.solutions.source.daos.BookstoreDAO;
import ejb.exercises.solutions.source.daos.BookstoreDaoFactory;
import ejb.exercises.solutions.source.dtos.BookDTO;

@SuppressWarnings("serial")
public class BookBean implements EntityBean {
	private double price;
	private String author;
	private String title;
	private BookstoreDAO dao;
	private EntityContext ctx;

	public void setEntityContext(EntityContext ictx) {
		ctx = ictx;
		try {
			InitialContext nctx = new InitialContext();
			DataSource dataSource = (DataSource) nctx.lookup("java:comp/env/jdbc/MyDS");
			dao = BookstoreDaoFactory.getDAO(dataSource);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException("failed to set Entity context");
		}

	}

	public void unsetEntityContext() {
		ctx = null;
	}

	public String ejbCreate(String ititle, String iauthor, double iprice) throws CreateException {
		dao.insertBook(ititle, iauthor, iprice);
		setTitle(ititle);
		setAuthor(iauthor);
		setPrice(iprice);
		return title;
	}

	public void ejbPostCreate(String ititle, String iauthor, double iprice) {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() throws RemoveException {
		dao.deleteBook((String) ctx.getPrimaryKey());
	}

	public void ejbLoad() {
		BookDTO book = dao.selectBook((String) ctx.getPrimaryKey());
		setTitle(book.getTitle());
		setAuthor(book.getAuthor());
		setPrice(book.getPrice());
	}

	public void ejbStore() {
		dao.updateBook(getTitle(), getAuthor(), getPrice());
	}

	public String ejbFindByPrimaryKey(String ititle) throws FinderException {
		if (dao.selectBook(ititle) != null) {
			return ititle;
		}

		throw new ObjectNotFoundException("Cannot find PK");
	}

	public Collection<String> ejbFindAllBooks() throws FinderException {
		List<BookDTO> books = dao.selectBooks();
		Collection<String> result = new ArrayList<String>();
		Iterator<BookDTO> it = books.iterator();
		while (it.hasNext()) {
			BookDTO book = it.next();
			result.add(book.getTitle());
		}
		return result;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String ititle) {
		title = ititle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String iauthor) {
		author = iauthor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double iprice) {
		price = iprice;
	}

}

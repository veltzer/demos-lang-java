package book;

import java.util.*;

import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;

import daos.*;
import dtos.*;

public class BookBean implements EntityBean {

	private double price;

	private String author;

	private String title;

	private BookstoreDAO dao;

	private EntityContext ctx;

	public void setEntityContext(EntityContext ctx)
		throws EJBException {
		this.ctx = ctx;
		try {
			InitialContext ictx = new InitialContext();
			DataSource dataSource =
				(DataSource) ictx.lookup("java:comp/env/jdbc/MyDS");
			dao = BookstoreDaoFactory.getDAO(dataSource);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EJBException("failed to set Entity context");
		}

	}

	public void unsetEntityContext() {
		ctx = null;
	}


	public String ejbCreate(String title, String author, double price)
		throws CreateException {
		dao.insertBook(title, author, price);
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		return title;
	}

	public void ejbPostCreate(String title, String author, double price) {
	}

	public void ejbActivate() {
	}
	
	public void ejbPassivate() {
	}

	public void ejbRemove()
		throws RemoveException {
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



	public String ejbFindByPrimaryKey(String title) throws FinderException {
		if (dao.selectBook(title) != null) {
			return title;
		}

		throw new ObjectNotFoundException("Cannot find PK");
	}
	
	public Collection ejbFindAllBooks() throws FinderException {
		List books = dao.selectBooks();
		Collection result = new ArrayList();
		Iterator it = books.iterator();
		while (it.hasNext()) {
			BookDTO book = (BookDTO) it.next();
			result.add(book.getTitle());
		}
		return result;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}

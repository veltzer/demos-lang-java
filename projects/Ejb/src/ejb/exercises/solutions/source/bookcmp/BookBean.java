package ejb.exercises.solutions.source.bookcmp;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

@SuppressWarnings("serial")
public abstract class BookBean implements EntityBean {
	public void setEntityContext(EntityContext ictx) {
	}
	public void unsetEntityContext() {
	}
	public void ejbRemove() {
	}
	public void ejbActivate() {
	}
	public void ejbPassivate() {
	}
	public void ejbLoad() {
	}
	public void ejbStore() {
	}
	public String ejbCreate(String title, String author, double price) {
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		return null;
	}
	public void ejbPostCreate(String title, String author, double price) {
	}
	public abstract String getTitle();
	public abstract void setTitle(String title);
	public abstract String getAuthor();
	public abstract void setAuthor(String author);
	public abstract double getPrice();
	public abstract void setPrice(double price);
}

package ejb.exercises.solutions.source.bookstore;

import javax.ejb.EJBHome;

public interface BookstoreAdminHome extends EJBHome {
	BookstoreAdmin create();
}

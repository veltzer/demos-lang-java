package ejb.exercises.exercises.source.daos;

import javax.sql.DataSource;

/**
 * A factory for obtaining bookstore DAO's. <br>
 * Current implementation simply returns a DAO implementation which
 * relies on sql92.
 */
public abstract class BookstoreDaoFactory {
	public static BookstoreDAO getDAO(DataSource dataSource) {
		return new SQL92BookstoreDAO(dataSource);
	}
}

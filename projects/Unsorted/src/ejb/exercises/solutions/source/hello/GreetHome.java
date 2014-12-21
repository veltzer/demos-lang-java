package ejb.exercises.solutions.source.hello;

import javax.ejb.EJBHome;
import javax.ejb.CreateException;
import java.rmi.RemoteException;

/**
 * Home interface for the Hello Bean
 */
public interface GreetHome extends EJBHome {
	/**
	 * Creates instances of the Greet bean
	 */
	Greet create() throws CreateException, RemoteException;
}

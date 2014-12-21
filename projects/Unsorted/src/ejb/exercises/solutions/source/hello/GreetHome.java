package ejb.exercises.solutions.source.hello;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * Home interface for the Hello Bean
 */
public interface GreetHome extends EJBHome {
	/**
	 * Creates instances of the Greet bean
	 */
	Greet create() throws CreateException, RemoteException;
}

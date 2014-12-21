package ejbwl.exercises.solutions.source.hello;

/**
 * Home interface for the Hello Bean
 */
public interface GreetHome extends javax.ejb.EJBHome
{
	/**
	 * Creates instances of the Greet bean
	 */
	public Greet create()
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}

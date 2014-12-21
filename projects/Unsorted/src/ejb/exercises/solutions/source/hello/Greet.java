package ejb.exercises.solutions.source.hello;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface Greet extends EJBObject {
	String getHelloMessage(String name) throws RemoteException;
}

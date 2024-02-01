package ejbwl.exercises.solutions.source.hello;

import javax.ejb.EJBObject;

public interface Greet extends EJBObject {
	String getHelloMessage(String name);
}

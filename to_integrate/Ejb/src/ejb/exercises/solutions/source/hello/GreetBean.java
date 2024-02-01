package ejb.exercises.solutions.source.hello;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * Bean implementation class for Greet
 */
@SuppressWarnings("serial")
public class GreetBean implements SessionBean {
	public void setSessionContext(SessionContext ctx) {
		System.out.println(
				getClass().getName() + ".setSessionContext() was invoked...");
	}

	public void ejbCreate() {
		System.out
				.println(getClass().getName() + ".ejbCreate() was invoked...");
	}

	public void ejbActivate() {
		System.out.println(
				getClass().getName() + ".ejbActivate() was invoked...");
	}

	public void ejbPassivate() {
		System.out.println(
				getClass().getName() + ".ejbPassivate() was invoked...");
	}

	public void ejbRemove() {
		System.out
				.println(getClass().getName() + ".ejbRemove() was invoked...");
	}

	public String getHelloMessage(String name) {
		return "Hello [" + name + "] from a Session Bean";
	}
}

package ejb.exercises.solutions.source.hello;

import javax.ejb.SessionBean;

/**
 * Bean implementation class for Greet
 */
@SuppressWarnings("serial")
public class GreetBean implements SessionBean {
	public void setSessionContext(javax.ejb.SessionContext ctx) {
		System.out.println(this.getClass().getName() + ".setSessionContext() was invoked...");
	}
	public void ejbCreate() throws javax.ejb.CreateException {
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
	}
	public void ejbActivate() {
		System.out.println(this.getClass().getName() + ".ejbActivate() was invoked...");
	}
	public void ejbPassivate() {
		System.out.println(this.getClass().getName() + ".ejbPassivate() was invoked...");
	}
	public void ejbRemove() {
		System.out.println(this.getClass().getName() + ".ejbRemove() was invoked...");
	}
	public String getHelloMessage(String name) {
		return "Hello [" + name + "] from a Session Bean";
	}
}

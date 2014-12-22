package exercise;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class LifecycleServlet extends GenericServlet {

	public LifecycleServlet() {
		super();
		System.out.println("Servlet instance created.");
	}

	public void init() {
		System.out.println("Servlet initialized.");
	}

	public void service(ServletRequest request, ServletResponse response) {
		System.out.println("Servlet handling the request.");
		response.getOutputStream().println("Hello World");
	}

	public void destroy() {
		System.out.println("Servlet destroyed.");
	}

}

package exercise;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class LifecycleServlet extends GenericServlet {
	public LifecycleServlet() {
		super();
		System.out.println("Servlet instance created.");
	}
	public void service(ServletRequest request, ServletResponse response) {
		System.out.println("Servlet handling the request.");
		try {
			response.getOutputStream().println("Hello World");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

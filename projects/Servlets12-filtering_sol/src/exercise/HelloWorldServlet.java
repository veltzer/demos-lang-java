package exercise;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class HelloWorldServlet extends GenericServlet {

	public void service(ServletRequest request, ServletResponse response) {
		response.getOutputStream().println("Hello World");
	}
}

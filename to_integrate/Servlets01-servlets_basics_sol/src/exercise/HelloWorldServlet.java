package exercise;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class HelloWorldServlet extends GenericServlet {
	public void service(ServletRequest request, ServletResponse response) {
		try {
			response.getOutputStream().println("Hello World");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

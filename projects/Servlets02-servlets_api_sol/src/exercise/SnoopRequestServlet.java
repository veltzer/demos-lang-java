package exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SnoopRequestServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		out.println("<h2>HTTP request is:</h2>");
		out.println(request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol() + "<br>");
		@SuppressWarnings("rawtypes")
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String hName = (String) e.nextElement();
			out.println(hName + ": " + request.getHeader(hName) + "<br>");
		}
	}
}

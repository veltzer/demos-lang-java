package exercise;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SnoopRequestServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = response.getWriter();
		out.println("<h2>HTTP request is:</h2>");
	}
}

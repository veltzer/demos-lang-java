package exercise;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CookiesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cookies Servlet</title>");
		out.println("</head>");
		out.println("<body>");

		// String cName = request.getParameter("cname");
		// String cVal = request.getParameter("cval");
		/*
		 * if (cName != null && cVal != null) { // Enter your code here }
		 */

		/**
		 * Enter your code here
		 */
		out.println("<form action='' method=POST>");
		out.println("Cookie name: <input type=text name=cname><br>");
		out.println("Cookie value: <input type=text name=cval><br>");
		out.println("<input type=submit value=Send cookie>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}

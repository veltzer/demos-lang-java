package jsf.jsf_vs_jsp.jspclass.src.mycompany.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycompany.business.GreetingBO;
import mycompany.business.GreetingREQ;
import mycompany.business.GreetingRES;

@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		// get request params
		String name = (String) req.getParameter("name");
		String cell = req.getParameter("cell");

		// validate the request params
		Boolean passedValidation = true;
		if (name.equals("") || cell.equals("")) {
			passedValidation = false;
		}

		// either run the business or create error message
		if (passedValidation) {
			// create business REQ and populate it
			GreetingREQ greetingREQ = new GreetingREQ();
			greetingREQ.setName(name);
			greetingREQ.setCell(Integer.valueOf(cell));

			// create business object and execute business method
			GreetingRES greetingRES = new GreetingRES();
			GreetingBO greetingBO = new GreetingBO();
			greetingRES = greetingBO.doGreeting(greetingREQ);

			// add the business response to the http request
			req.setAttribute("greetingRES", greetingRES);
		} else {
			req.setAttribute("errorMessage", "your input is wrong");
		}

		// forward the execution to the correct jsp
		String destinationResource;
		if (passedValidation) {
			destinationResource = "/WEB-INF/jsp/greeting.jsp";
		} else {
			destinationResource = "/WEB-INF/jsp/info.jsp";
		}

		getServletConfig().getServletContext().getRequestDispatcher(
				destinationResource).forward(req, res);

	}
}

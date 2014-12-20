
package jsp_exercises.design_patterns.solutions.dispatcherview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Dispatcher {
	private ServletContext ctx;

	private static final String CATALOG_PAGE = "/list.jsp";
	private static final String ITEM_PAGE = "/item.jsp";

	Dispatcher(ServletContext ctx) {
		this.ctx = ctx;
	}

	void dispatch(ServletRequest req, ServletResponse res, String mode) throws IOException,ServletException {
		RequestDispatcher rd = null;
		if (mode.equalsIgnoreCase("cat")) {
			rd =  ctx.getRequestDispatcher(CATALOG_PAGE);
		} else if (mode.equalsIgnoreCase("item")) {
			rd =  ctx.getRequestDispatcher(ITEM_PAGE);
		} else {
			throw new ServletException("Illegal mode");
		}
		rd.forward(req,res);

	}

}

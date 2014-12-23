
package jsp.solutions.designpatterns.dispatcherview;

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
	private static final String ERR_STRING1 = "illegal mode";

	Dispatcher(ServletContext ictx) {
		ctx = ictx;
	}
	void dispatch(ServletRequest req, ServletResponse res, String mode) {
		RequestDispatcher rd = null;
		if (mode.equalsIgnoreCase("cat")) {
			rd = ctx.getRequestDispatcher(CATALOG_PAGE);
		} else if (mode.equalsIgnoreCase("item")) {
			rd = ctx.getRequestDispatcher(ITEM_PAGE);
		} else {
			throw new RuntimeException(ERR_STRING1);
		}
		try {
			rd.forward(req, res);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

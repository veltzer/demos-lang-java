package jsp.solutions.designpatterns.dispatcherview;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet {
	private Dispatcher dispatcher;

	public void init(ServletConfig config) {
		try {
			super.init(config);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}

		// create the items list;
		Map<String, Item> itemList = new TreeMap<String, Item>();
		itemList.put("1", new Item("1", "Monitor", 250));
		itemList.put("2", new Item("2", "Hard disk", 79.90));
		itemList.put("3", new Item("3", "Mouse", 19.90));
		itemList.put("4", new Item("4", "Keyboard", 29.90));
		itemList.put("5", new Item("5", "CPU", 145.50));
		itemList.put("6", new Item("6", "Fan", 8.89));

		ServletContext ctx = config.getServletContext();
		ctx.setAttribute("items", itemList);
		dispatcher = new Dispatcher(ctx);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String mode = request.getParameter("mode");
		dispatcher.dispatch(request, response, mode);
	}
}

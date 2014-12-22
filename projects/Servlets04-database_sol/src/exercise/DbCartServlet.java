package exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class DbCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		addItemToCart(request);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cart Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Welcome to John's computer shop</h2>");
		printCart(request, response);
		printItems(request, response);
		out.println("</body>");
		out.println("</html>");
	}

	private Map<String, Item> getItemsList() {
		try {
			ItemDAO itemDao = new ItemDAO();
			return itemDao.findAllItems();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	private void addItemToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		if (cart == null) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		String itemId = request.getParameter("itemid");
		if (itemId != null) {
			Map<String, Item> items = getItemsList();
			Item item = items.get(itemId);
			if (item != null) {
				cart.add(item);
			}
		}
	}

	private void printCart(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		out.println("Items currently in your cart:<br>");
		double total = 0;
		if (cart.isEmpty()) {
			out.println("Cart is empty.");
		} else {
			Iterator<Item> it = cart.iterator();
			while (it.hasNext()) {
				Item item = it.next();
				out.println(item.getName() + " - " + NumberFormat.getCurrencyInstance(Locale.US).format(item.getPrice()) + "<br>");
				total += item.getPrice();
			}
		}
		out.println("<h5>Total: " + NumberFormat.getCurrencyInstance(Locale.US).format(total) + "</h5>");
		out.println("<br>");
	}

	private void printItems(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		out.println("<h4>Items for sale:</h4>");
		Map<String, Item> items = getItemsList();
		Iterator<Item> it = items.values().iterator();
		while (it.hasNext()) {
			Item item = it.next();
			out.println(item.getItemId()
					+ " "
					+ item.getName()
					+ " - "
					+ NumberFormat.getCurrencyInstance(Locale.US).format(
							item.getPrice()));
			out.println("<a href='"
					+ response.encodeURL(request.getRequestURI() + "?itemid="
							+ item.getItemId()) + "'>Buy now!</a><br>");
		}
	}
}

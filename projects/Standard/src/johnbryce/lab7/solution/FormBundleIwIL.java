package johnbryce.lab7.solution;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ListResourceBundle;

import javax.swing.SwingConstants;

public class FormBundleIwIL extends ListResourceBundle {

	private static final Object[][] CONTENT = {
			{
					"align", SwingConstants.RIGHT
			}, {
					"title", "title"
			}, {
					"dateMsg", "dateMsg"
			}, {
					"date", "date"
			}, {
					"dateVal", DateFormat.getDateInstance(DateFormat.SHORT)
			}, {
					"time", "time"
			}, {
					"timeVal", DateFormat.getTimeInstance(DateFormat.SHORT)
			}, {
					"orderMsg", "orderMsg"
			}, {
					"item", "item"
			}, {
					"units", "units"
			}, {
					"unitsVal", NumberFormat.getNumberInstance()
			}, {
					"unitPrice", "unitPrice"
			}, {
					"unitPriceVal", NumberFormat.getCurrencyInstance()
			}, {
					"total", "total"
			}, {
					"ok", "ok"
			}, {
					"cancel", "cancel"
			}
	};

	@Override
	protected Object[][] getContents() {
		return CONTENT;
	}

}

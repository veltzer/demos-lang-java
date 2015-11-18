package johnbryce.lab7.solution;


	import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ListResourceBundle;

import javax.swing.SwingConstants;

	public class FormBundle extends ListResourceBundle {

		private static final Object[][] content={
			{"align",SwingConstants.LEFT},
			{"title","Order Details"},
			{"dateMsg","Date of issue"},
			{"date","Date"},
			{"dateVal",DateFormat.getDateInstance(DateFormat.SHORT)},
			{"time","Time"},
			{"timeVal",DateFormat.getTimeInstance(DateFormat.SHORT)},
			{"orderMsg","Item details"},
			{"item","Item ID"},
			{"units","Units"},
			{"unitsVal",NumberFormat.getNumberInstance()},
			{"unitPrice","Unit Price"},
			{"unitPriceVal",NumberFormat.getCurrencyInstance()},
			{"total","Total"},
			{"ok","OK"},
			{"cancel","Cancel"}
		};

		@Override
		protected Object[][] getContents() {
			return content;
		}

}

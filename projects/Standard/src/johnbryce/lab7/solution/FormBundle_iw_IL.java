package uiBundle;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ListResourceBundle;

import javax.swing.SwingConstants;
 
public class FormBundle_iw_IL extends ListResourceBundle {

	private static final Object[][] content={
		{"align",SwingConstants.RIGHT},
		{"title","פרטי הזמנה"},
		{"dateMsg","תאריך ההזמנה"},
		{"date","יום"},
		{"dateVal",DateFormat.getDateInstance(DateFormat.SHORT)},
		{"time","שעה"},
		{"timeVal",DateFormat.getTimeInstance(DateFormat.SHORT)},
		{"orderMsg","פרטי הפריט"},
		{"item","קוד פריט"},
		{"units","מס' יחידות"},
		{"unitsVal",NumberFormat.getNumberInstance()},
		{"unitPrice","מחיר ליחידה"},
		{"unitPriceVal",NumberFormat.getCurrencyInstance()},
		{"total","סה\"כ לתשלום"},
		{"ok","אישור"},
		{"cancel","ביטול"}
	};
	
	@Override
	protected Object[][] getContents() {
		return content;
	}


}

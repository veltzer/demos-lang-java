package format;

import java.text.DateFormatSymbols;
import java.util.*;

public class CalendarPrint {

	/** Creates a new instance of Main */
	public CalendarPrint() {
		GregorianCalendar c = new GregorianCalendar();
		// Set the month to use
		c.set(Calendar.MONTH, 5);
		print(c);
	}

	public void print(GregorianCalendar c) {
		Formatter f = new Formatter(System.out, Locale.ENGLISH);

		c = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH),
				c.get(Calendar.DAY_OF_MONTH));

		f.format("%tB %<tY\n", c);
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		String[] dayNames = dfs.getShortWeekdays();
		for (String day : dayNames) {
			if (day.equals(""))
				continue;
			f.format("%-4s", day);
		}
		f.format("\n");

		c.set(Calendar.DAY_OF_MONTH, 1);
		for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			f.format("%4s", "");
		}
		do {
			f.format("%3te ", c);
			c.roll(Calendar.DAY_OF_YEAR, true);
			if (c.get(Calendar.DAY_OF_WEEK) == c.getFirstDayOfWeek())
				f.format("%n");
		} while (c.get(Calendar.DAY_OF_MONTH) > 1);
		f.format("%n%n");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		new CalendarPrint();
	}
}

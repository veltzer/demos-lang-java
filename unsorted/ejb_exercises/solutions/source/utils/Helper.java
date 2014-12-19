package utils;

import java.util.Calendar;

public class Helper
{
	/**
	 * private constructor
	 */
	private Helper() {}

	/**
	 * This static method returns the current date and time asa string in the
	 * format "DD/MM/YYY HH:MM:SS:ss"
	 * @return A string in the format "DD/MM/YYY HH:MM:SS:ss"
	 */
	public static String getCurrentDateTime()
	{
		//declare locals
		String ret = "";
		String day = "";
		String month = "";
		String year = "";
		String hours = "";
		String minutes = "";
		String seconds = "";
		String milliseconds = "";
		Calendar cal = null;

		//create a new Calendar object with the current date and time
		cal = Calendar.getInstance();

		//get the current time's tokens
		day = "" + cal.get(Calendar.DAY_OF_MONTH);
		if (day.length()<2)
		{
			day = "0" + day;
		}
		month = "" + (cal.get(Calendar.MONTH)+1);
		if (month.length()<2)
		{
			month = "0" + month;
		}
		year = "" + cal.get(Calendar.YEAR);
		hours = "" + cal.get(Calendar.HOUR_OF_DAY);
		if (hours.length()<2)
		{
			hours = "0" + hours;
		}
		minutes = "" + cal.get(Calendar.MINUTE);
		if (minutes.length()<2)
		{
			minutes = "0" + minutes;
		}
		seconds = "" + cal.get(Calendar.SECOND);
		if (seconds.length()<2)
		{
			seconds = "0" + seconds;
		}
		milliseconds = "" + cal.get(Calendar.MILLISECOND);

		//format the return value
		ret = day + "/" + month + "/" + year + " " + hours + ":" + minutes + ":" + seconds + ":" + milliseconds;

		//return the method's value
		return(ret);
	}
}

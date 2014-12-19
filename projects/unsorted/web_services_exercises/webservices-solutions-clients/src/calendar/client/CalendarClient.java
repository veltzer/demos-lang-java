package calendar.client;

import java.util.*;

import javax.xml.datatype.*;

import calendar.client.proxy.*;

public class CalendarClient {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException
	 */
	public static void main(String[] args) throws DatatypeConfigurationException {
		HebCalendarService service = new HebCalendarService();
		HebCalendar port = service.getHebCalendarPort();

		DatatypeFactory factory = DatatypeFactory.newInstance();
		XMLGregorianCalendar date = factory.newXMLGregorianCalendar((GregorianCalendar) GregorianCalendar.getInstance());

		String day = port.hebDayOfWeek(date);

		System.out.println("Today is "+day);

		day = port.hebDayName(7);

		System.out.println("Saterday is "+day);
	}

}

package calendar.client;

import java.util.*;

import javax.xml.datatype.*;
import javax.xml.ws.*;

import calendar.client.proxy.*;

public class CalendarAsyncClient {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException
	 */
	public static void main(String[] args) throws DatatypeConfigurationException {
		HebCalendarService service = new HebCalendarService();
		HebCalendar port = service.getHebCalendarPort();

		AsyncHandler<HebDayOfWeekResponse> handler = new AsyncHandler<HebDayOfWeekResponse>() {

			public void handleResponse(Response<HebDayOfWeekResponse> res) {
				try {
					System.out.println("Response arrived: "+res.get().getReturn());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		};

		DatatypeFactory factory = DatatypeFactory.newInstance();
		XMLGregorianCalendar date = factory.newXMLGregorianCalendar((GregorianCalendar) GregorianCalendar.getInstance());

		port.hebDayOfWeekAsync(date, handler);
		System.out.println("Waiting for the response...");


	}

}

package calendar.client;

public abstract class CalendarClient {
	/**
	 * @param args
	 * @throws DatatypeConfigurationException
	 */
	public static void main(String[] args) {
		HebCalendarService service = new HebCalendarService();
		HebCalendar port = service.getHebCalendarPort();
		DatatypeFactory factory = DatatypeFactory.newInstance();
		XMLGregorianCalendar date = factory.newXMLGregorianCalendar(
				(GregorianCalendar) GregorianCalendar.getInstance());
		String day = port.hebDayOfWeek(date);
		System.out.println("Today is " + day);
		day = port.hebDayName(7);
		System.out.println("Saterday is " + day);
	}

}

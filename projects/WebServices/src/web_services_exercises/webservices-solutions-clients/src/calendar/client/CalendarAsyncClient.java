package calendar.client;

public abstract class CalendarAsyncClient {

	/**
	 * @param args
	 * @throws DatatypeConfigurationException
	 */
	public static void main(String[] args) {
		HebCalendarService service = new HebCalendarService();
		HebCalendar port = service.getHebCalendarPort();
		AsyncHandler<HebDayOfWeekResponse> handler = new AsyncHandler<HebDayOfWeekResponse>() {
			public void handleResponse(Response<HebDayOfWeekResponse> res) {
				try {
					System.out.println(
							"Response arrived: " + res.get().getReturn());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		DatatypeFactory factory = DatatypeFactory.newInstance();
		XMLGregorianCalendar date = factory.newXMLGregorianCalendar(
				(GregorianCalendar) GregorianCalendar.getInstance());
		port.hebDayOfWeekAsync(date, handler);
		System.out.println("Waiting for the response...");
	}
}

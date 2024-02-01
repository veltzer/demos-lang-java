package calendar.client;

public abstract class CalendarSAAJClient {
	public static void main(String[] args) {
		try {
			String result = hebDayNum(7);
			System.out.println("Result: " + result);
		} catch (SOAPException e) {
			throw new RuntimeException(e);
		}
	}

	private static String hebDayNum(int dayNum) {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();

		// Create objects for the message parts
		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody body = envelope.getBody();

		QName bodyName = new QName("http://service.calendar/", "hebDayName");

		SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

		// Add content
		bodyElement.addChildElement("dayNum").addTextNode(dayNum + "");

		String destination = "http://localhost:8080/services/hebcalendar";

		SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection connection = soapConnFactory.createConnection();

		SOAPMessage response = connection.call(message, destination);

		body = response.getSOAPBody();
		SOAPElement resElement = (SOAPElement) body.getChildElements(
				new QName("http://service.calendar/", "hebDayNameResponse"))
				.next();

		return resElement.getTextContent();
	}
}

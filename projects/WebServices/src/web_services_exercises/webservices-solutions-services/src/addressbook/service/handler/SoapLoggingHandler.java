package addressbook.service.handler;

public class SoapLoggingHandler implements SOAPHandler<SOAPMessageContext> {

	public Set<QName> getHeaders() {
		return null;
	}

	public void close(MessageContext context) {

	}

	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	public boolean handleMessage(SOAPMessageContext context) {
		Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (outboundProperty.booleanValue()) {
			System.out.println("\nOutbound message:");
		} else {
			System.out.println("\nInbound message:");
		}

		SOAPMessage message = context.getMessage();
		try {
			message.writeTo(System.out);
			System.out.println("");
		} catch (Exception e) {
			System.out.println("Exception in handler: " + e);
		}
		return true;

	}

}

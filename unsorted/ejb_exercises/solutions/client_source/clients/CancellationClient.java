package clients;
import javax.jms.*;
import javax.naming.InitialContext;

/**
 * A simple JMS client that places a cancellation requests
 * into a dedicated queue.
 */
public class CancellationClient {

	public static void main(String[] args) throws Exception{
		InitialContext ctx = new InitialContext();

		// Prepare:
		// connection factory, connection, queue, session, sender
		QueueConnectionFactory qConFact =
			(QueueConnectionFactory)ctx.lookup("jms/qCon1");
		QueueConnection qCon =
			qConFact.createQueueConnection();
		Queue queue = (Queue)ctx.lookup("jms/q1");
		QueueSession qSession =qCon.createQueueSession(
			false,Session.AUTO_ACKNOWLEDGE);
		QueueSender sender = qSession.createSender(queue);

		// Send message:
		TextMessage msg = qSession.createTextMessage();
		String  cancellationText="cancel 0.07706566154030858";
		msg.setText(cancellationText);
		sender.send(msg);
		System.out.println("Message has been sent");

		// Release resources:
		sender.close();
		qSession.close();
		qCon.close();
	}
}

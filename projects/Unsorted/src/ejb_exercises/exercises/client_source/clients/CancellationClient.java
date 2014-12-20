package ejb_exercises.exercises.client_source.clients;

/**
 * A simple JMS client that places a cancellation requests
 * into a dedicated queue.
 */
public class CancellationClient {
	public static void main(String[] args) {
		// Lookup JMS resources - here you should get a reference to the JMS
		// resources you need in order to send the message to the queue.
		// The queue connection factory JNDI name is "jms/qCon1" and the queue name
		// is jms/q1


		// Send message - here you should send a text message to the queue with
		// the ID of the order you would like to cancel:


		// Release resources - close all JMS resource. This is typically done in a
		//"finally" block:

	}
}

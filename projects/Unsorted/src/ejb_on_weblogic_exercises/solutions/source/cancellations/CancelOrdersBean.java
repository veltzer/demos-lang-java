package cancellations;

import java.util.StringTokenizer;

import javax.ejb.*;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;
import daos.BookstoreDAO;
import daos.BookstoreDaoFactory;

/**
 * Bean implementation class for Enterprise Bean: CancelOrders
 */
public class CancelOrdersBean implements MessageListener, MessageDrivenBean {

	private MessageDrivenContext fMessageDrivenCtx;
	private BookstoreDAO dao;

	/**
	* setMessageDrivenContext
	*/
	public void setMessageDrivenContext(javax.ejb.MessageDrivenContext ctx) {
		System.out.println(this.getClass().getName() + ".setMessageDrivenContext() was invoked...");
		fMessageDrivenCtx = ctx;
		try {
			InitialContext ictx=new InitialContext();
			Object obj = ictx.lookup("java:comp/env/jdbc/MyDS");
			DataSource dataSrouce = (DataSource) PortableRemoteObject.narrow(obj,DataSource.class);
			dao=BookstoreDaoFactory.getDAO(dataSrouce);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("failed to set context");
		}
	}

	public void ejbCreate() {
		System.out.println(this.getClass().getName() + ".ejbCreate() was invoked...");
	}

	public void ejbRemove() {
		System.out.println(this.getClass().getName() + ".ejbRemove() was invoked...");
	}

	/**
	* This method is invoked wheneven a message arrives into
	* the queue to which bean is registered. <br>
	* For the purpose of this exercise, assume the only messages
	* are text messages regarding order cancellations. <br>
	*
	* NOTE: since call is asynchronous, there is no simple way
	* to inform clients when cancellation fails (e.g. if order does
	* not exists). Currently, we shall simply print out a warning.
	* When error reports are critical, they should be dispatched to
	* client a-synchroniously (e.g. using email, or having the client
	* register to a dedicated "error-notification" queue , where your
	* message-driven bean may place error reports).
	*/
	public void onMessage(Message msg) {
		System.out.println(this.getClass().getName() + ".onMessage() was invoked...");

		try {
			// Assuming only messages are TextMessages (otherwise,
			// use instanceof):
			TextMessage tMsg= (TextMessage)msg;

			// Assuming text is of the form "cancel <orderId>":
			String text=tMsg.getText();
			StringTokenizer tok=new StringTokenizer(text);
			tok.nextToken(); // skip "cancel"
			String orderId=tok.nextToken();

			// This should cascade-delete the order:
			System.out.println("*** About to cancel order:"+ orderId);
			dao.cancelOrder(orderId);
			System.out.println("*** Successfully cancelled order:"+ orderId);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

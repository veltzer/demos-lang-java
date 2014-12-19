import javax.microedition.lcdui.*;

/**
 * Exercise 1: Hello World Midlet.
 */
public class HelloWorld extends javax.microedition.midlet.MIDlet {

	/** Constructor. */
	public HelloWorld() {
		System.out.println("MIDlet created");

		// Normally the Midlet would perform any one time intializations here.
	}

	/** Signals the MIDlet to terminate and enter the Destroyed state. */
	protected void destroyApp(boolean unconditional) {
		System.out.println("MIDlet destroyed, unconditional=" + unconditional);

		// Normally the Midlet would perform any final cleanup here.
	}

	/** Signals the MIDlet to stop and enter the Paused state. */
	protected void pauseApp() {
		System.out.println("MIDlet paused");

		// Normally the Midlet would release any shared resources here and pause execution.
	}

	/** Signals the MIDlet that it has entered the Active state. */
	protected void startApp() {
		System.out.println("MIDlet started");

		System.out.println("\nMidlet manifest + application descriptor attributes");
		System.out.println("---------------------------------------------------");
		System.out.println("MIDlet-1: " + getAppProperty("MIDlet-1"));
		System.out.println("MIDlet-Name: " + getAppProperty("MIDlet-Name"));
		System.out.println("MIDlet-Vendor: " + getAppProperty("MIDlet-Vendor"));
		System.out.println("MIDlet-Version: " + getAppProperty("MIDlet-Version"));
		System.out.println("MicroEdition-Configuration: " + getAppProperty("MicroEdition-Configuration"));
		System.out.println("MicroEdition-Profile: " + getAppProperty("MicroEdition-Profile"));
		System.out.println("MIDlet-Jar-Size: " + getAppProperty("MIDlet-Jar-Size"));
		System.out.println("MIDlet-Jar-URL: " + getAppProperty("MIDlet-Jar-URL"));

		System.out.println("\nMidlet system properties");
		System.out.println("------------------------");
		System.out.println("microedition.configuration: " + System.getProperty("microedition.configuration"));
		System.out.println("microedition.profiles: " + System.getProperty("microedition.profiles"));
		System.out.println("microedition.platform: " + System.getProperty("microedition.platform"));
		System.out.println("microedition.locale: " + System.getProperty("microedition.locale"));
		System.out.println("microedition.encoding: " + System.getProperty("microedition.encoding"));

		System.out.println("\nMidlet display properties");
		System.out.println("-------------------------");
		System.out.println("Midlet display number of colors: " + Display.getDisplay(this).numColors());

		System.out.println("\nMidlet system memory");
		System.out.println("---------------------");
		System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
		System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());

		System.out.println("\nMidlet user defined application descriptor attribute");
		System.out.println("---------------------------------------------------");
		System.out.println("My-Property: " + getAppProperty("My-Property"));

		// Normally the Midlet would allocate any shared resources here and begin execution.
  }
}

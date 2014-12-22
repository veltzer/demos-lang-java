package jme.exercises.stock;

/**
 * Exercise 5: Stock ticker.
 */
public class Stock extends MIDlet implements CommandListener {
	private static final String URL = "http://quote.yahoo.com/d/quotes.csv?f=g&s=";
	private Form form; // Main form
	private TextField textField; // Used to enter stock symbol
	private Command submitCmd, helpCmd, aboutCmd, exitCmd;
	private Displayable pausedDisplayable; // Last Displayble object visible before Midlet paused

	/** Constructor. */
	public Stock() {
		// Intialize commands.
		submitCmd = new Command("SUBMIT", Command.SCREEN, 1);
		helpCmd = new Command("HELP", Command.HELP, 2);
		aboutCmd = new Command("ABOUT", Command.HELP, 3);
		exitCmd = new Command("EXIT", Command.EXIT, 4);

		// Initialize form.
		form = new Form("Stock Ticker");
		form.setCommandListener(this);
		form.addCommand(submitCmd);
		form.addCommand(helpCmd);
		form.addCommand(aboutCmd);
		form.addCommand(exitCmd);

		// Initialize text box.
		textField = new TextField("Symbol", null, 10, TextField.ANY); // Allow up to 10 characters per symbol
		form.append(textField);
	}

	/** Signals the MIDlet to terminate and enter the Destroyed state. */
	protected void destroyApp(boolean unconditional) {
	}

	/** Signals the MIDlet to stop and enter the Paused state. */
	protected void pauseApp() {
		pausedDisplayable = Display.getDisplay(this).getCurrent(); // Save reference to current displayable.
	}

	/** Signals the MIDlet that it has entered the Active state. */
	protected void startApp() {
		if (pausedDisplayable != null) {
			Display.getDisplay(this).setCurrent(pausedDisplayable); // Re-display last previously shown displayable if available.
			pausedDisplayable = null;
		} else {
			Display.getDisplay(this).setCurrent(form);
		}
	}

	/** Indicates that a command event has occurred on Displayable d. */
	public void commandAction(Command c, Displayable d) {
		if (c == submitCmd) {
			// Retrieve quote for symbol entered in text field.
			if (textField.getString().length() > 0) {
				retrieveQuote(textField.getString()); // @todo Should do this in separate thread, while giving user an indication of progress
			}
		} else if (c == helpCmd) {
			showHelp();
		} else if (c == aboutCmd) {
			showAbout();
		} else if (c == exitCmd) {
			destroyApp(false);
			notifyDestroyed();
		}
	}

	/** Retrieve a quote for the given stock symbol via HTTP over the network. */
	private void retrieveQuote(String symbol) {
		HttpConnection conn = null;
		InputStream is = null;

		try {
			conn = (HttpConnection) Connector.open(URL + symbol);
			conn.setRequestMethod(HttpConnection.GET); // Not required, since GET is default. Can also be used for POST request.
			conn.setRequestProperty("User-Agent", "Profile/MIDP-1.0 Configuration/CLDC-1.0"); // Example of setting request property

			is = conn.openInputStream(); // Open connection to read input

			StringBuffer buf = new StringBuffer(6);
			int i;

			// Read each character of input and append to StringBuffer
			while ((i = is.read()) != -1) {
				buf.append((char) i);
			}

			showMessage(symbol, buf.toString()); // Display result to user
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			try {
				conn.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/** Display help dialog. */
	private void showHelp() {
		Alert helpAlert = new Alert("Help");
		helpAlert.setTimeout(Alert.FOREVER);
		helpAlert.setString("A simple stock ticker application. Enter a valid stock symbol in the text field and use the SUBMIT command to retrieve a current quote.");
		Display.getDisplay(this).setCurrent(helpAlert);
	}

 	/** Display about dialog. */
	private void showAbout() {
		Alert aboutAlert = new Alert("About");
		aboutAlert.setTimeout(Alert.FOREVER);

		// Build about string using StringBuffer for efficiency.
		StringBuffer sb = new StringBuffer(75);
		sb.append(getAppProperty("MIDlet-Name"));
		sb.append("\nversion ").append(getAppProperty("MIDlet-Version"));
		sb.append("\nlocale ").append(System.getProperty("microedition.locale"));
		sb.append("\nby Jamie Hall");

		aboutAlert.setString(sb.toString());
		Display.getDisplay(this).setCurrent(aboutAlert);
	}

	/** Display an dialog with the given title and text. */
	private void showMessage(String title, String text) {
		Alert errorAlert = new Alert(title);
		errorAlert.setTimeout(Alert.FOREVER);
		errorAlert.setString(text);
		Display.getDisplay(this).setCurrent(errorAlert);
	}
}

import javax.microedition.lcdui.*;

/**
 * Exercise 3: Slide Show Midlet.
 */
public class SlideShow extends javax.microedition.midlet.MIDlet implements CommandListener {
	private SlideShowCanvas slideShowCanvas; // Used to display images.
	private Command nextCmd, prevCmd, helpCmd, aboutCmd, exitCmd;
	private Displayable pausedDisplayable; // Last Displayble object visible before Midlet paused

	/** Constructor. */
	public SlideShow() {
		// Intialize commands.
		nextCmd = new Command("NEXT", Command.SCREEN, 1);
		prevCmd = new Command("PREVIOUS", Command.SCREEN, 2);
		helpCmd = new Command("HELP", Command.HELP, 3);
		aboutCmd = new Command("ABOUT", Command.HELP, 4);
		exitCmd = new Command("EXIT", Command.EXIT, 5);

		// Load all images in sequence (slide1.png, slide2.png, etc.) until we can't load any more.
		java.util.Vector imagesVector = new java.util.Vector();
		try {
			for (int i = 0;; i++) {
				Image img = Image.createImage("/slide" + (i+1) + ".png"); // If this fails, we exit from loop
				imagesVector.addElement(img);
			}
		}
		catch (Exception e) {} // Ignore

		Image[] images = new Image[imagesVector.size()];
		imagesVector.copyInto(images); // Copy images in vector to array

		slideShowCanvas = new SlideShowCanvas(images);
		slideShowCanvas.setCommandListener(this);
		slideShowCanvas.addCommand(nextCmd);
		slideShowCanvas.addCommand(prevCmd);
		slideShowCanvas.addCommand(helpCmd);
		slideShowCanvas.addCommand(aboutCmd);
		slideShowCanvas.addCommand(exitCmd);
	}

	/** Signals the MIDlet to terminate and enter the Destroyed state. */
	protected void destroyApp(boolean unconditional) {}

	/** Signals the MIDlet to stop and enter the Paused state. */
	protected void pauseApp() {
		pausedDisplayable = Display.getDisplay(this).getCurrent(); // Save reference to current displayable.
	}

	/** Signals the MIDlet that it has entered the Active state. */
	protected void startApp() {
		if (pausedDisplayable != null) {
			Display.getDisplay(this).setCurrent(pausedDisplayable); // Re-display last previously shown displayable if available.
			pausedDisplayable = null;
		}
		else {
			Display.getDisplay(this).setCurrent(slideShowCanvas);
		}
  }

  /** Indicates that a command event has occurred on Displayable d. */
  public void commandAction(Command c, Displayable d) {
		if (c == nextCmd) {
			slideShowCanvas.advanceForward(); // Display next image in sequence.
		}
		else if (c == prevCmd) {
			slideShowCanvas.advanceBackward(); // Display previous image in sequence.
		}
		else if (c == helpCmd) {
			showHelp();
		}
	  else if (c == aboutCmd) {
	    showAbout();
	  }
		else if (c == exitCmd) {
			destroyApp(false);
			notifyDestroyed();
	  }
	}

  /** Display help dialog. */
  private void showHelp() {
	  Alert helpAlert = new Alert("Help");
		helpAlert.setTimeout(Alert.FOREVER);
		helpAlert.setString("A simple slide show application. Use the available commands or keyboard shortcuts to advance through the images.");
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
}

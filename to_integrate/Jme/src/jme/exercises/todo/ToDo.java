package jme.exercises.todo;

import javax.microedition.midlet.MIDlet;

/**
 * Exercise 2: To do list part I.
 */
public class ToDo extends MIDlet implements CommandListener {
	private List list; // List to display all entries
	private TextBox textBox; // Text box to add and edit entries
	private Command addEntryCmd, deleteEntryCmd, editEntryCmd, helpCmd,
			aboutCmd, exitCmd, okCmd, cancelCmd;
	private Vector entries = new Vector(); // List of all Entry objects
	private Displayable pausedDisplayable; // Last Displayble object visible
											// before Midlet paused
	private int editEntryIndex; // Index of entry currently being edited, or -1
								// if none

	/** Constructor. */
	public ToDo() {
		// Intialize commands.
		addEntryCmd = new Command("ADD", Command.SCREEN, 1);
		deleteEntryCmd = new Command("DELETE", Command.SCREEN, 2);
		editEntryCmd = new Command("EDIT", Command.SCREEN, 3);
		helpCmd = new Command("HELP", Command.HELP, 4);
		aboutCmd = new Command("ABOUT", Command.HELP, 5);
		exitCmd = new Command("EXIT", Command.EXIT, 6);
		okCmd = new Command("OK", Command.OK, 1);
		cancelCmd = new Command("CANCEL", Command.CANCEL, 2);

		// Initialize list.
		list = new List("To Do List", List.IMPLICIT);
		list.setCommandListener(this);
		list.addCommand(addEntryCmd);
		list.addCommand(deleteEntryCmd);
		list.addCommand(editEntryCmd);
		list.addCommand(helpCmd);
		list.addCommand(aboutCmd);
		list.addCommand(exitCmd);

		// Initialize text box.
		textBox = new TextBox(null, null, 500, TextField.ANY); // Allow up to
																// 500
																// characters
																// per entry
		textBox.setCommandListener(this);
		textBox.addCommand(okCmd);
		textBox.addCommand(cancelCmd);
	}

	/** Signals the MIDlet to terminate and enter the Destroyed state. */
	protected void destroyApp(boolean unconditional) {
	}

	/** Signals the MIDlet to stop and enter the Paused state. */
	protected void pauseApp() {
		pausedDisplayable = Display.getDisplay(this).getCurrent(); // Save
																	// reference
																	// to
																	// current
																	// displayable.
	}

	/** Signals the MIDlet that it has entered the Active state. */
	protected void startApp() {
		if (pausedDisplayable != null) {
			Display.getDisplay(this).setCurrent(pausedDisplayable); // Re-display
																	// last
																	// previously
																	// shown
																	// displayable
																	// if
																	// available.
			pausedDisplayable = null;
		} else {
			Display.getDisplay(this).setCurrent(list);
		}
	}

	/** Indicates that a command event has occurred on Displayable d. */
	public void commandAction(Command c, Displayable d) {
		if (c == addEntryCmd) {
			// Display text box to add new entry.
			editEntryIndex = -1;
			textBox.setTitle("Add");
			textBox.setString(null); // Clear previous contents
			Display.getDisplay(this).setCurrent(textBox); // Display text box
		} else if (c == deleteEntryCmd) {
			// Delete currently selected entry.
			// @todo Confirm before deleting
			if (list.getSelectedIndex() > -1) {
				deleteEntry(list.getSelectedIndex());
			}
		} else if (c == editEntryCmd) {
			// Edit currently selected entry by displaying text box with entry
			// contents.
			if (list.getSelectedIndex() > -1) {
				editEntryIndex = list.getSelectedIndex();
				Entry entry = (Entry) entries.elementAt(editEntryIndex);
				textBox.setTitle("Edit");
				textBox.setString(entry.text);
				Display.getDisplay(this).setCurrent(textBox);
			}
		} else if (c == helpCmd) {
			showHelp();
		} else if (c == aboutCmd) {
			showAbout();
		} else if (c == exitCmd) {
			destroyApp(false);
			notifyDestroyed();
		} else if (c == okCmd) {
			if (textBox.getString().length() > 0) {
				if (editEntryIndex < 0) {
					addEntry(textBox.getString());
				} else {
					editEntry(textBox.getString());
				}
			}
			Display.getDisplay(this).setCurrent(list);
		} else if (c == cancelCmd) {
			Display.getDisplay(this).setCurrent(list);
		}
	}

	/** Add new entry with given String. */
	private void addEntry(String stringToAdd) {
		Entry newEntry = new Entry(stringToAdd);
		entries.addElement(newEntry); // Add to Vector
		list.append(newEntry.toString(), null); // Add to List
	}

	/** Delete entry at given index. */
	private void deleteEntry(int selectedIndex) {
		entries.removeElementAt(selectedIndex); // Delete from Vector
		list.delete(selectedIndex); // Delete from List
	}

	/** Edit current entry with given String. */
	private void editEntry(String stringToEdit) {
		Entry entry = (Entry) entries.elementAt(editEntryIndex);
		entry.text = stringToEdit; // Edit Vector Entry
		entry.date = new Date(); // Update timestamp
		list.set(editEntryIndex, entry.toString(), null); // Edit List item
	}

	/** Display help dialog. */
	private void showHelp() {
		Alert helpAlert = new Alert("Help");
		helpAlert.setTimeout(Alert.FOREVER);
		helpAlert.setString(
				"A simple to do list application. Use the available commands to add, delete or edit entries in the list.");
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
		sb.append("\nlocale ")
				.append(System.getProperty("microedition.locale"));
		sb.append("\nby Jamie Hall");

		aboutAlert.setString(sb.toString());
		Display.getDisplay(this).setCurrent(aboutAlert);
	}

	/** Inner class to hold basic information for to do list entries. */
	class Entry {
		private String text;
		private Date date;

		/** Constructor. */
		public Entry(String itext) {
			text = itext;
			date = new Date();
		}

		/** Return a String representation of this Entry. */
		public String toString() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String dateString = calendar.get(Calendar.YEAR) + "-"
					+ (calendar.get(Calendar.MONTH) + 1) + "-"
					+ calendar.get(Calendar.DATE) + " "
					+ calendar.get(Calendar.HOUR_OF_DAY) + ":"
					+ (calendar.get(Calendar.MINUTE) < 10
							? "0" + calendar.get(Calendar.MINUTE)
							: "" + calendar.get(Calendar.MINUTE));
			return text.substring(0, Math.min(text.length(), 10)) + " ["
					+ dateString + "]";
		}
	}
}

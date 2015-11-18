package designpatterns.exercises.command;

import java.util.ArrayList;
import java.util.List;

public class SimpleEditor {
	private StringBuffer textBuffer;
	private List<EditorCommand> commands;
	private int currentCommandIndex;

	private class AppendCommand implements EditorCommand {
		private String appendText;

		public AppendCommand(String iappendText) {
			appendText = iappendText;
		}

		public void execute() {
			textBuffer.append(appendText);
		}

		public void unexecute() {
			textBuffer.setLength(textBuffer.length() - appendText.length());
		}
	}

	private class DeleteCommand implements EditorCommand {
		private int fromIndex;
		private int endIndex;
		private String deletedText;

		public DeleteCommand(int ifromIndex, int iendIndex) {
			deletedText = "";
			fromIndex = ifromIndex;
			endIndex = iendIndex;
		}

		public void execute() {
			deletedText = textBuffer.substring(fromIndex, endIndex);
			textBuffer.delete(fromIndex, endIndex);
		}

		public void unexecute() {
			textBuffer.insert(fromIndex, deletedText);
		}
	}

	public SimpleEditor() {
		super();
		textBuffer = new StringBuffer();
		commands = new ArrayList<EditorCommand>();
		currentCommandIndex = 0;
	}

	public void addCommand(EditorCommand command) {
		commands = commands.subList(0, currentCommandIndex);
		commands.add(command);
		currentCommandIndex = commands.size();
		command.execute();

		System.out.println("Text: " + textBuffer);
	}

	public void undo() {
		if (currentCommandIndex == 0) {
			return;
		}
		--currentCommandIndex;
		EditorCommand command = commands.get(currentCommandIndex);
		command.unexecute();
		System.out.println("Text: " + textBuffer);
	}

	public void redo() {
		if (currentCommandIndex == commands.size()) {
			return;
		}
		EditorCommand command = commands.get(currentCommandIndex);
		command.execute();
		++currentCommandIndex;

		System.out.println("Text: " + textBuffer);
	}

	private void demo() {
		addCommand(new AppendCommand("abc "));
		addCommand(new AppendCommand("def "));
		addCommand(new AppendCommand("ghi "));
		addCommand(new DeleteCommand(2, 5));

		undo();
		undo();
		undo();
		redo();
		addCommand(new AppendCommand("jkl "));
	}

	public static void main(String[] args) {
		try {
			SimpleEditor editor = new SimpleEditor();
			editor.demo();
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

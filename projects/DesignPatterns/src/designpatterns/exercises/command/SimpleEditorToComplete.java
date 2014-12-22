package designpatterns.exercises.command;

public class SimpleEditorToComplete {
	private StringBuffer textBuffer;

	private class AppendCommand implements EditorCommand {
		public AppendCommand(String s) { }
		public void execute() {
		}
		public void unexecute() {
		}
	}

	private class DeleteCommand implements EditorCommand {
		public DeleteCommand(int from, int howmuch) {
		}
		public void execute() {
		}
		public void unexecute() {
		}
	}

	public SimpleEditorToComplete() {
		super();
		textBuffer = new StringBuffer();
	}

	public void addCommand(EditorCommand command) {
		System.out.println("Text: " + textBuffer);
	}

	public void undo() {
		System.out.println("Text: " + textBuffer);
	}

	public void redo() {
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
			SimpleEditorToComplete editor = new SimpleEditorToComplete();
			editor.demo();
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

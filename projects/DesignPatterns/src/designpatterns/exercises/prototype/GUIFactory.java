package designpatterns.exercises.prototype;

public class GUIFactory {
	private Button button;
	private ComboBox combo;

	public GUIFactory(Button ibutton, ComboBox icombo) {
		button = ibutton;
		combo = icombo;
	}

	public Button createButton() {
		return (Button) button.clone();
	}

	public ComboBox createComboBox() {
		return (ComboBox) combo.clone();
	}
}

package jsf.solutions_and_examples.ex4.src.com.acme.calculator;

import javax.faces.event.ActionEvent;

public class CalculatorBean {
	private static final int NOP = 0;
	private static final int PLUS = 1;
	private static final int MINUS = 2;
	private static final int DIV = 3;
	private static final int TIMES = 4;
	private static final int EQ = 5;

	// Scientific mode:
	private static final int POWER2 = 10;
	private static final int SQRT = 11;

	private static final int MODE_NORMAL = 0;
	private static final int MODE_SCI = 1;

	private static final String[] CHANGE_MODE_MESSAGE =
		new String[] {
			"Scientific mode", // Shown in normal mode
			"Normal mode" // Shown in scientific mode
		};

	private double lastValue = 0.0;
	private int lastOp = NOP;

	private int mode = MODE_NORMAL;

	private double displayValue;

	public double getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(double idisplayValue) {
		displayValue = idisplayValue;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int imode) {
		mode = imode;
	}

	public String getChangeModeMessage() {
		// A calculated, read-only property.
		return CHANGE_MODE_MESSAGE[mode];
	}

	public boolean isScientificRendered() {
		return (mode == MODE_SCI);
	}

	private void calc(int newOp) {
		/* You can use a selected output component on the form
		 * for debug output, as shown here (commented out; the
		 * component itself is also commented out in the HTML.)
		 */
//		UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
//		UIOutput output = (UIOutput) root.findComponent("calc:debug");
//		output.setValue("newOp = " + newOp);

		switch (lastOp) {
		case PLUS:
			lastValue += displayValue;
			break;
		case MINUS:
			lastValue -= displayValue;
			break;
		case TIMES:
			lastValue *= displayValue;
			break;
		case DIV:
			lastValue /= displayValue;
			break;
		case POWER2:
			lastValue = displayValue * displayValue;
			break;
		case SQRT:
			lastValue = Math.sqrt(displayValue);
			break;
		default:
			lastValue = displayValue;
		}

		setDisplayValue(lastValue);
		lastOp = newOp;
	}

	public void doPlus(ActionEvent event) {
		calc(PLUS);
	}

	public void doMinus(ActionEvent event) {
		calc(MINUS);
	}

	public void doTimes(ActionEvent event) {
		calc(TIMES);
	}

	public void doDiv(ActionEvent event) {
		calc(DIV);
	}

	public void doEq(ActionEvent event) {
		calc(EQ);
	}

	public void doPower2(ActionEvent event) {
		lastOp = POWER2; // This is an instant-go command
		calc(EQ);
	}

	public void doSqrt(ActionEvent event) {
		lastOp = SQRT; // This is an instant-go command
		calc(EQ);
	}

	public void flipMode(ActionEvent event) {
		setMode(1 - getMode()); // From 0 to 1 or vice versa
	}
}

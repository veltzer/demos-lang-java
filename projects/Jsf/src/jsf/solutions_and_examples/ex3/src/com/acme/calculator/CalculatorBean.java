package jsf.solutions_and_examples.ex3.src.com.acme.calculator;

public class CalculatorBean {
	private static final int NOP = 0;
	private static final int PLUS = 1;
	private static final int MINUS = 2;
	private static final int DIV = 3;
	private static final int TIMES = 4;
	private static final int EQ = 5;

	private double lastValue = 0.0;
	private int lastOp = NOP;
	private double displayValue;

	public double getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(double idisplayValue) {
		displayValue = idisplayValue;
	}

	private void calc(int newOp) {
		/*
		 * You can use a selected output component on the form for debug output,
		 * as shown here (commented out; the component itself is also commented
		 * out in the HTML.)
		 */

		// UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
		// UIOutput output = (UIOutput) root.findComponent("calc:debug");
		// output.setValue("newOp = " + newOp);

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

}

package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class ToStringPrimitive extends PerformaceTest {
	private int i;

	public void init() {
		i = 0;
	}

	public void cycle() {
		Integer.toString(i);
	}

	public void done() {
	}
}

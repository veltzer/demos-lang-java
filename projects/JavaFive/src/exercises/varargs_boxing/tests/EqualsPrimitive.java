package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class EqualsPrimitive extends PerformaceTest {
	private int i;
	private boolean b;

	public void init() {
		i = 0;
	}
	public void cycle() {
		b = i == 1;
	}
	public void done() {
	}
}

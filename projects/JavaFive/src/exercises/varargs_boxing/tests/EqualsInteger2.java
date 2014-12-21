package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class EqualsInteger2 extends PerformaceTest {
	private Integer i;
	private boolean b;

	public void init() {
		i = 0;
	}
	public void cycle() {
		b = i.equals(256);
	}
	public void done() {
	}
}

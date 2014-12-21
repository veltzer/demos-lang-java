package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class EqualsInteger extends PerformaceTest {
	private Integer i;
	public void init() {
		i = 0;
	}
	public void cycle() {
		i.equals(1);
	}
	public void done() {
	}
}

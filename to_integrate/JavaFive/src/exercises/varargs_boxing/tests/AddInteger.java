package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class AddInteger extends PerformaceTest {
	private Integer i;

	public void init() {
		i = 0;
	}

	public void cycle() {
		i += 1;
	}

	public void done() {
	}
}

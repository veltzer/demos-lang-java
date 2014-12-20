package java_5_exercises.ex1_varargs_boxing.tests;

import java_5_exercises.ex1_varargs_boxing.PerformaceTest;

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

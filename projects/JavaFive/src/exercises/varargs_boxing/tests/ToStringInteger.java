package exercises.varargs_boxing.tests;

import exercises.varargs_boxing.PerformaceTest;

public class ToStringInteger extends PerformaceTest {
    Integer i;

    public void init() { i=0; }
    public void cycle() { i.toString(); }
    public void done() {}
}

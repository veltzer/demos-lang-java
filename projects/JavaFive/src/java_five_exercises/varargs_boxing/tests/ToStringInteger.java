package java_five_exercises.varargs_boxing.tests;

import java_five_exercises.varargs_boxing.PerformaceTest;

public class ToStringInteger extends PerformaceTest {
    Integer i;

    public void init() { i=0; }
    public void cycle() { i.toString(); }
    public void done() {}
}

package java_five_exercises.varargs_boxing.tests;

import java_five_exercises.varargs_boxing.PerformaceTest;

public class EqualsInteger extends PerformaceTest {
    Integer i;
    boolean b;

    public void init() { i=0; }
    public void cycle() { b=i.equals(1); }
    public void done() {}
}

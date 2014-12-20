package java_5_exercises.ex1_varargs_boxing.tests;

import java_5_exercises.ex1_varargs_boxing.PerformaceTest;

public class ToStringInteger extends PerformaceTest {
    Integer i;

    public void init() { i=0; }
    public void cycle() { i.toString(); }
    public void done() {}
}

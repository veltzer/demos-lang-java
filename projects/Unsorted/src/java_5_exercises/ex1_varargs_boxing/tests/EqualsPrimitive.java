package java_5_exercises.ex1_varargs_boxing.tests;

import java_5_exercises.ex1_varargs_boxing.PerformaceTest;

public class EqualsPrimitive extends PerformaceTest {
    int i;
    boolean b;

    public void init() { i=0; }
    public void cycle() { b=i==1; }
    public void done() {}
}

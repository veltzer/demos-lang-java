package boxing.tests;

import boxing.*;

public class ToStringPrimitive extends PerformaceTest {
    int i;

    public void init() { i=0; }
    public void cycle() { Integer.toString(i); }
    public void done() {}
}

package boxing.tests;

import boxing.*;

public class EqualsInteger2 extends PerformaceTest {
    Integer i;
    boolean b;

    public void init() { i=0; }
    public void cycle() { b=i.equals(256); }
    public void done() {}
}

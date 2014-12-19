package boxing.tests;

import boxing.*;

public class ToStringInteger extends PerformaceTest {
    Integer i;

    public void init() { i=0; }
    public void cycle() { i.toString(); }
    public void done() {}
}

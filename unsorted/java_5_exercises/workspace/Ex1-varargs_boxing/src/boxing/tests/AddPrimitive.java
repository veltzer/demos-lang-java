package boxing.tests;

import boxing.*;

public class AddPrimitive extends PerformaceTest {
    int i;

    public void init() { i=0; }
    public void cycle() { i+=1; }
    public void done() {}
}

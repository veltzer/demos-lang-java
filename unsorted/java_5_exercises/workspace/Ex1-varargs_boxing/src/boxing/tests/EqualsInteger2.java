/*
 * EqualsPrimitive.java
 *
 * Created on May 2, 2005, 5:26 AM
 */

package boxing.tests;

import boxing.*;

/**
 *
 * @author pix
 */
public class EqualsInteger2 extends PerformaceTest {
    Integer i;
    boolean b;

    public void init() { i=0; }
    public void cycle() { b=i.equals(256); }
    public void done() {}
}

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
public class EqualsInteger extends PerformaceTest {
    Integer i;
    boolean b;

    public void init() { i=0; }
    public void cycle() { b=i.equals(1); }
    public void done() {}
}

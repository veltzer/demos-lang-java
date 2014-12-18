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
public class ToStringInteger extends PerformaceTest {
    Integer i;

    public void init() { i=0; }
    public void cycle() { i.toString(); }
    public void done() {}
}

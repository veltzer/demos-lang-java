/*
 * IterableStringTokenizer.java
 *
 * Created on May 5, 2005, 1:16 AM
 */

package forin;

import java.util.*;

/**
 *
 * @author pix
 */
public class UnSafeIterableStringTokenizer 
	extends StringTokenizer implements Iterable {
    
    public UnSafeIterableStringTokenizer(String str,
                       String delim,
                       boolean returnDelims) {
         super(str,delim,returnDelims);
    }

    public UnSafeIterableStringTokenizer(String str,
                       String delim) {
         super(str,delim);
    }

    public UnSafeIterableStringTokenizer(String str) {
         super(str);
    }

    public Iterator iterator() {
        return new Iterator() {
            public boolean hasNext() { return hasMoreTokens(); }
            public Object next() { return nextToken(); }
            public void remove() { throw new UnsupportedOperationException("remove() not supported"); }
        };
    }
    
    public static void main(String[] args) {
        String s = "Hello World, how are you?";
        UnSafeIterableStringTokenizer si = new UnSafeIterableStringTokenizer(s);
        for (Object w: si) {
            System.out.println(w);
        }
    }
}













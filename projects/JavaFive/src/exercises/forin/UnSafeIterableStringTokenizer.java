package exercises.forin;

import java.util.Iterator;
import java.util.StringTokenizer;

public class UnSafeIterableStringTokenizer
	extends StringTokenizer implements Iterable<Object> {

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

    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
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













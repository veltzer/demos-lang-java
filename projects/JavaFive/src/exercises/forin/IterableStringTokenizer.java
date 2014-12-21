package exercises.forin;

import java.util.Iterator;
import java.util.StringTokenizer;

public class IterableStringTokenizer extends StringTokenizer implements Iterable<String> {

    public IterableStringTokenizer(String str,
                       String delim,
                       boolean returnDelims) {
         super(str,delim,returnDelims);
    }

    public IterableStringTokenizer(String str,
                       String delim) {
         super(str,delim);
    }

    public IterableStringTokenizer(String str) {
         super(str);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            public boolean hasNext() { return hasMoreTokens(); }
            public String next() { return nextToken(); }
            public void remove() { throw new UnsupportedOperationException("remove() not supported"); }
        };
    }

    public static void main(String... args) {
        String s = "Hello World, how are you?";
        IterableStringTokenizer si = new IterableStringTokenizer(s);
        for (String w: si)
            System.out.println(w);
    }

}

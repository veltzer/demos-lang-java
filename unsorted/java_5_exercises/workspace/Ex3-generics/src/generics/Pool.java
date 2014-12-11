/*
 * Pool.java
 *
 * Created on April 27, 2005, 4:42 PM
 */

package generics;

import java.util.*;

/**
 *
 * @author pix
 */
public class Pool<T> {
    List<T> arr;

    /** 
     * Creates a new instance of Pool 
     * Class<T> is used to make sure that the Class instance passed as a 
     * parameter is of type T. 
     */
    public Pool(Class<T> type, int capacity) {
        if (capacity<1) throw new IllegalArgumentException("capacity must be greater then one");
        arr = new ArrayList<T>(capacity);
        try {
            for (int i=0;i<capacity;i++)
                arr.add(type.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T get() {
        if (arr.size()==0) return null;
        return arr.remove(arr.size()-1);
    }
    
    public void free(T t) {
        arr.add(t);
    }
    
    public static void main(String[] args) {
        Pool<TestClass> p = new Pool<TestClass>(TestClass.class,3);
        for (TestClass r=p.get();r!=null;r=p.get())
            System.out.println(r);
    }
    
}

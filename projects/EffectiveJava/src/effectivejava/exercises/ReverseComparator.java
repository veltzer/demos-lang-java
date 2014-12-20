package effectivejava.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 */
public class ReverseComparator<T> implements Comparator<T> {
  private final Comparator<T> comp;
  public ReverseComparator(Comparator<T> comparator) {
    comp = comparator;
  }

  public int compare(T o1, T o2) {
    //return comp.compare(o2, o1);
    int cmp = comp.compare(o1, o2);
    return cmp > 0 ? -1 : cmp < 0 ? 1 : 0;
  }

  public static void main(String[] args) {
    Comparator<Integer> intComp = new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1 < o2 ? Integer.MIN_VALUE : o1 > o2 ? Integer.MAX_VALUE : 0;
      }
    };
    List<Integer> l = Arrays.asList(3,1,4,2);
    Collections.sort(l, new ReverseComparator<Integer>(intComp));
//    Collections.sort(l, intComp);
    System.out.println(l);
  }

}

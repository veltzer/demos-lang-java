package effective_java_exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

public class Heap<E> implements Iterable<E> {
  @SuppressWarnings("unused")
private Comparator<? super E> comparator;
  public Heap(Comparator<? super E> c) { comparator = c; }

  public E pop() {
    return null; //todo
  }
  public void add(E elem) {
    //todo
  }
  public void addAll(Collection<? extends E> c) {
    for (E e: c) { add(e); }
  }
  public void popAll(Collection<? super E> c) {
    while (!isEmpty()) c.add(pop());
  }
  public boolean isEmpty() {
    return true; //todo
  }
  public Iterator<E> iterator() {
    return null; //todo
  }
  public boolean contains(Object o) { return false; }

  public static <T> boolean myContains(Heap<?> l, T elem) {
    return l.contains(elem);
  }

  public static void main(String[] args) {
    Comparator<Object> co = new Comparator<Object>() {
      @Override
      public int compare(Object o1, Object o2) {
        return Integer.valueOf(System.identityHashCode(o1)).
                compareTo(System.identityHashCode(o2));
      }
    };
    Heap<Number> h = new Heap<Number>(co);
    h.contains(3);
    myContains(h, "hello");
    List<Integer> i = new ArrayList<Integer>();
    i.contains(5);
    h.addAll(i);
    List<Object> o = new ArrayList<Object>();
    h.popAll(o);
  }

}

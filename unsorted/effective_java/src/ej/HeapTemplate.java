package ej;

import java.util.Collection;
import java.util.Comparator;

/**
 * @author: Yardena
 */
public abstract class Heap implements Iterable {
  final Comparator comparator;

  protected Heap(Comparator c) { comparator = c; }

  abstract Object pop();
  abstract void add(Object o);
  abstract void addAll(Collection c);
  abstract void popAll(Collection c);
  abstract Iterator iterator();
  
}

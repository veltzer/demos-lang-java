package ej;

import extreme.threads.Semaphore;

import java.util.*;

/**
 * @author: Yardena
 * @date: Nov 9, 2009 1:53:59 PM
 */
public class BoundedSet<T> extends AbstractSet<T> {
  private final Set<T> data;
  private final Semaphore semaphore;

  public BoundedSet(int capacity) {
    data = Collections.synchronizedSet(new HashSet<T>(capacity));
    semaphore = new Semaphore(capacity);
  }

  @Override public Iterator<T> iterator() {
    return data.iterator();
  }

  @Override public int size() {
    return data.size();
  }

  @Override public boolean add(T element) {
    semaphore.up(1);
    boolean wasAdded = false;
    try {
      return wasAdded = data.add(element);
    } finally {
      if (!wasAdded) semaphore.down(1);
    }
  }

  @Override public boolean remove(Object element) {
    boolean wasRemoved = data.remove(element);
    if (wasRemoved) semaphore.down(1);
    return wasRemoved;
  }

}

package effective_java_exercises;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

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
    try {
		semaphore.acquire();
	} catch (InterruptedException e) {
		throw new RuntimeException(e);
	}
    boolean wasAdded = false;
    try {
      return wasAdded = data.add(element);
    } finally {
      if (!wasAdded) semaphore.release();
    }
  }

  @Override public boolean remove(Object element) {
    boolean wasRemoved = data.remove(element);
    if (wasRemoved) semaphore.release();
    return wasRemoved;
  }

}

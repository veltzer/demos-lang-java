package effectivejava.exercises;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public abstract class HeapTemplate<T> implements Iterable<T> {
	protected HeapTemplate(Comparator<T> c) {
	}

	abstract Object pop();
	abstract void add(Object o);
	abstract void addAll(Collection<T> c);
	abstract void popAll(Collection<T> c);
	public abstract Iterator<T> iterator();
}

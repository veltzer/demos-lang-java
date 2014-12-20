package ej;

import java.util.Collection;
import java.util.Comparator;

public abstract class HeapTemplate implements Iterable {
	final Comparator comparator;

	protected HeapTemplate(Comparator c) { comparator = c; }

	abstract Object pop();
	abstract void add(Object o);
	abstract void addAll(Collection c);
	abstract void popAll(Collection c);
	abstract Iterator iterator();
}

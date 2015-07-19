package core.threads;

import java.util.LinkedList;

/**
 * A simple blocking queue.
 */
public class BlockingQueue<E> {
	private LinkedList<E> linkedList;

	public BlockingQueue() {
		linkedList = new LinkedList<E>();
	}

	public synchronized E take() {
		while (linkedList.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return linkedList.removeFirst();
	}

	public synchronized void put(E e) {
		linkedList.addLast(e);
		notify();
	}
}
